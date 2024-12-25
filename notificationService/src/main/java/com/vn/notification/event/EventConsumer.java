package com.vn.notification.event;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {

    @KafkaListener(topics = "test",containerFactory = "kafkaListenerContainerFactory")
        public void listen(String message){
        System.out.println("Received message: " + message);
        }

}
