# Spring Integration

## What is spring integration?
1. Enable light weight messaging platforms
2. Supports integration with external systems.
3. Adapter provides high level abstraction for support.

It Follows the pipes and filter paradigm
Pipes => transport messages.
Filer => Produce or consume messages.


## Integration Components:
### Message:
1. Holds the message and headers.
   Message Channel:
1. Represents the pipes in the paradigm
2. Similar to Kafka, channels can be subscribed to multiple consumers, or point to point where only one consumer can consume.
   Message Endpoints:
1. Message endpoints are like filters, which connects the application code to the messaging framework.
2. Application code doesn’t have any info on messaging framework.
3. Similar in HTTP MVC , it handles requests, in MessageEndpoint it handles messages.

## Main Components:
1. Message Transformer
    1. It is responsible for converting messages and manipulating the headers
    2. Most Common use case is to convert the payload from one dataType to another.
2. Message Filter.
    1. Determines whether the message to be returned to the output channel.
    2. Main Use case is when multiple subscribers are subscribed to the channel, filter can be used to identify the message to be processed.
3. Message Router
    1. Decides which channel should receive message next.
4. Splitter/Aggregator:
    1. Splitter splits the message into multiple small payloads.
    2. Aggregator combines multiple message into a single message.
5. Service Actuator:
    1. connecting a service instance to the messaging system
    2. Configures the input and output channel.
6. Channel Adapter:
    1. endpoint that connects a message channel to some other system or transport
    2. Convert to message from other object while receiving

## Different types of Channels:
1. QueueChannel
2. PriorityChannel
3. RendezvousChannel
4. DirectChannel
5. ExecutorChannel
6. FluxMessageChannel
7. Scoped Channel

### ****** Checkout each branch for the specific task. JPA/JDBC are Work in progress ******
