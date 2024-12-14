package com.chatdemo.camping.infrasctructure.kafka;

import com.chatdemo.camping.domains.entity.UserMessage;
import  com.chatdemo.camping.domains.ports.KafkaPort;
import com.chatdemo.camping.infrasctructure.kafka.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class KafkaAdapter implements KafkaPort {
    private final MessageProducer messageProducer;
    @Value("${spring.kafka.topic.name}")
    private  String topic;
    @Override
    public void sendMessage(UserMessage model) {
        try{
            Message<UserMessage> msg = MessageBuilder.withPayload(model)
                    .setHeader(KafkaHeaders.TOPIC, topic)
                    .setHeader(KafkaHeaders.KEY, model.getSenderCode())
                    .setHeader("version", "1.0.0")
                    .build();
            messageProducer.sendMessage(topic, msg, model.getSenderCode());
        }catch(Exception e){
            log.info("Erro ao enviar mensagem para o Kafka");
        }


    }
}
