package com.chatdemo.camping.domains.resourses;

import com.chatdemo.camping.domains.models.UserMessage;

public interface MessageSender {
    void send(UserMessage mensagem);
}
