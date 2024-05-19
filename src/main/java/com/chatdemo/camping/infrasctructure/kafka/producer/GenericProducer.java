package com.chatdemo.camping.infrasctructure.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
@RequiredArgsConstructor
public class GenericProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    Logger log = Logger.getLogger(String.valueOf(GenericProducer.class));

    public void sendMessage(String topic,Object object, String key) {
        try{
            kafkaTemplate.send(topic, key, object);
        } catch (Exception e){
            log.info("Erro ao enviar mensagem para o Kafka");
        }
    }
}