package com.vn.notification.event;


import com.vn.commonService.services.EmailService;
import org.apache.kafka.common.errors.RetriableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.DltStrategy;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EventConsumer {
    @Autowired
    private EmailService emailService;


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

    @KafkaListener(topics = "testEmail",containerFactory = "kafkaListenerContainerFactory")
    public void testEmail(String message){
        System.out.println("Received message: " + message);


        emailService.sendSimpleMail(message,"Thanks for listening","test",true,null);

    }

    @KafkaListener(topics = "emailTemplate",containerFactory = "kafkaListenerContainerFactory")
    public void testEmailTemplate(String message){
        System.out.println("Received message: " + message);
        Map<String,Object> map = new HashMap<>();
        map.put("idCode","TrinhQuangLam");
        emailService.sendEmailWithTemplate(message,"Welcome to Christmas","emailTemplate.ftl",map,null);



    }



}
