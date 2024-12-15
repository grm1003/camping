package com.chatdemo.camping.infrasctructure.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Log4j2
public class MessageProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, Object object, String key) {
        try{
            kafkaTemplate.send(topic, key, object);
        } catch (Exception e){
            log.info("Erro ao enviar mensagem para o Kafka");
        }
    }
}