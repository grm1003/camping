package com.chatdemo.camping.infrasctructure.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.group_id.name}")
    public void consume(ConsumerRecord<String, Object> record) {
        System.out.println("Consumed message: " + record.value() + ", Key: " + record.key());
    }
}