package com.chatdemo.camping.infrasctructure.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenericProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic,Object object, String key) throws BadRequestException {
        try{
            kafkaTemplate.send(topic, key, object);
        } catch (Exception e){
            throw new BadRequestException("Erro ao enviar mensagem");
        }
    }
}