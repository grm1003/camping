package com.chatdemo.camping.infrasctructure.kafka.producer;

import com.chatdemo.camping.domains.entity.UserMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Component
@RequiredArgsConstructor
@Log4j2
public class MessageProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic,Object object, String key) {
        try{
            kafkaTemplate.send(topic, key, object);
        } catch (Exception e){
            log.info("Erro ao enviar mensagem para o Kafka");
        }
    }
}