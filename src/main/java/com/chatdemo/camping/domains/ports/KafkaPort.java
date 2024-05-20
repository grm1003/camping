package com.chatdemo.camping.domains.ports;

import com.chatdemo.camping.domains.entity.UserMessage;

public interface KafkaPort {
    public void sendMessage(UserMessage mensagem);
}
