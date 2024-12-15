package com.chatdemo.camping.domains.usecases;

import com.chatdemo.camping.domains.models.UserMessage;
import com.chatdemo.camping.domains.ports.KafkaPort;
import com.chatdemo.camping.domains.resourses.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageSenderImpl implements MessageSender {
    private final KafkaPort kafkaPort;
    @Override
    public void send(UserMessage mensagem) {
      kafkaPort.sendMessage(mensagem);
    }
}
