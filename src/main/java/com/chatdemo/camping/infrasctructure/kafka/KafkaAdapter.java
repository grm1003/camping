package com.chatdemo.camping.infrasctructure.kafka;

import com.chatdemo.camping.domains.entity.UserMessage;
import  com.chatdemo.camping.domains.ports.KafkaPort;
import com.chatdemo.camping.infrasctructure.kafka.producer.GenericProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

//@Log4j
@Component
@RequiredArgsConstructor
public class KafkaAdapter implements KafkaPort {
    private final GenericProducer genericProducer;
    @Value("${spring.kafka.topic.name}")
    private  String topic;
    @Override
    public void sendMessage(UserMessage model) {
        try{
            Message<UserMessage> msg = MessageBuilder.withPayload(model)
                    .setHeader(KafkaHeaders.TOPIC, topic)
                    .setHeader(KafkaHeaders.KEY, model.getUserCode())
                    .setHeader("version", "1.0.0")
                    .build();
            genericProducer.sendMessage(topic, msg, "teste");
        }catch(Exception e){
           // log.info();
        }


    }
}
