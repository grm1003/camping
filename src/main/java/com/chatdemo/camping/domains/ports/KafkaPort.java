package com.chatdemo.camping.domains.ports;

import com.chatdemo.camping.domains.models.UserMessage;

public interface KafkaPort {
    public void sendMessage(UserMessage mensagem);
}
