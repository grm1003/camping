package com.chatdemo.camping.infrasctructure.kafka.consumer;

import com.chatdemo.camping.domains.models.UserMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.group_id.name}",
            properties = {
                    "spring.json.add.type.headers=false"
            })
    public void consume(ConsumerRecord<String, Object> message, Acknowledgment ack) {
        try {
            System.out.println("Consumed message: " + message.value() + ", Key: " + message.key());
            ack.acknowledge();
        } catch (Exception e) {
            System.out.println("Erro ao consumir mensagem do Kafka: " + e);
            ack.acknowledge();
        }
    }
}