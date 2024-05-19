package com.chatdemo.camping.infrasctructure.kafka;

import com.chatdemo.camping.domains.ports.KafkaPort;
import com.chatdemo.camping.infrasctructure.kafka.producer.GenericProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericApplicationContext;

@RequiredArgsConstructor
public class KafkaAdapter implements KafkaPort {
    private final GenericProducer genericProducer;
    @Value("${spring.kafka.topic.name}")
    private final String topic;
    @Override
    public void enviarMensagem(String mensagem) {
        genericProducer.sendMessage(topic, mensagem, "teste");

    }
}
