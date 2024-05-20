package com.chatdemo.camping.domains.resourses;

import com.chatdemo.camping.domains.entity.UserMessage;

public interface MessageSender {
    void send(UserMessage mensagem);
}
