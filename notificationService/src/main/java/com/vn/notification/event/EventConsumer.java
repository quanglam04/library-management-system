package com.vn.notification.event;


import org.apache.kafka.common.errors.RetriableException;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.DltStrategy;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {

    @RetryableTopic(
            attempts = "4" ,// 3 topic retry + 1 topic DLQ
            backoff = @Backoff(delay = 1000,multiplier = 2),
            autoCreateTopics = "true",
            dltStrategy = DltStrategy.FAIL_ON_ERROR,
            include = {RetriableException.class,RuntimeException.class}
    )
    @KafkaListener(topics = "test",containerFactory = "kafkaListenerContainerFactory")
        public void listen(String message){
        System.out.println("Received message: " + message);

        throw new RuntimeException("Error test");
        }
    @DltHandler
    void processDltMessage(@Payload String message){
        System.out.println("DLT receive message: "+message);
    }

}
