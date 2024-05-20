package com.chatdemo.camping.domains.entity;


import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class UserMessage {
    private String userCode;
    private String message;
    private TypeMessageEnum type;
    private Optional<List<String>> receivers;

}
