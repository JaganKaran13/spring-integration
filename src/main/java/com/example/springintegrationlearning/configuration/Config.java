package com.example.springintegrationlearning.configuration;

import com.example.springintegrationlearning.model.Product;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ResolvableType;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.integration.config.EnableIntegration;

import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.gateway.MessagingGatewaySupport;
import org.springframework.integration.http.inbound.HttpRequestHandlingMessagingGateway;
import org.springframework.integration.http.inbound.RequestMapping;
import org.springframework.integration.http.support.DefaultHttpHeaderMapper;
import org.springframework.integration.mapping.HeaderMapper;

@Configuration
@ComponentScan(basePackages = "com.example.springintegrationlearning")
@EnableIntegration
public class Config {

    // parse payload expressions
    @Bean
    public ExpressionParser parser() {
        return new SpelExpressionParser();
    }

    // map HTTP headers from/to message headers.
    @Bean
    public HeaderMapper<HttpHeaders> headerMapper() {
        return new DefaultHttpHeaderMapper();
    }

    @Bean
    public IntegrationFlow httpGetFlow() {
        return IntegrationFlows.from(httpGetGate()).channel("httpGetChannel").handle("productEndpoint", "get").get();
    }

    @Bean
    public IntegrationFlow httpPostFlow() {
        return IntegrationFlows.from("httpPostChannel").handle("productEndpoint", "post").get();
    }

    @Bean
    public IntegrationFlow httpPostPutFlow() {
        return IntegrationFlows.from(httpPostPutGate()).channel("routeRequest").route("headers.http_requestMethod",
                m -> m.prefix("http").suffix("Channel")
                        .channelMapping("PUT", "Put")
                        .channelMapping("POST", "Post")
        ).get();
    }
    @Bean
    public MessagingGatewaySupport httpGetGate() {
        HttpRequestHandlingMessagingGateway handler = new HttpRequestHandlingMessagingGateway();
        handler.setRequestMapping(createMapping(new HttpMethod[]{HttpMethod.GET}, "/product/{productId}"));
        handler.setPayloadExpression(parser().parseExpression("#pathVariables.productId"));
        handler.setHeaderMapper(headerMapper());
        return handler;
    }

    private RequestMapping createMapping(HttpMethod[] method, String... path) {
        RequestMapping requestMapping = new RequestMapping();
        requestMapping.setMethods(method);
        requestMapping.setConsumes("application/json");
        requestMapping.setProduces("application/json");
        requestMapping.setPathPatterns(path);
        return requestMapping;
    }

    @Bean
    public MessagingGatewaySupport httpPostPutGate() {
        HttpRequestHandlingMessagingGateway handler = new HttpRequestHandlingMessagingGateway();
        handler.setRequestMapping(createMapping(new HttpMethod[]{HttpMethod.POST}, "/product"));
        handler.setStatusCodeExpression(parser().parseExpression("T(org.springframework.http.HttpStatus).NO_CONTENT"));
        handler.setRequestPayloadType(ResolvableType.forClass(Product.class));
        handler.setHeaderMapper(headerMapper());
        return handler;
    }
}
