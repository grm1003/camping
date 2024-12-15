package com.chatdemo.camping.infrasctructure.api.request;

import com.chatdemo.camping.domains.models.TypeMessageEnum;
import com.chatdemo.camping.domains.models.UserMessage;
import lombok.Data;

import java.util.List;


@Data
public class MessageRequest {
    private String message;
    private String type;
    private List<String> receiversCodes;

    public UserMessage toModel(String sender) {
        return UserMessage.builder()
                .senderCode(sender)
                .message(message)
                .type(TypeMessageEnum.valueOf(type))
                .receiversCodes(receiversCodes)
                .build();
    }
}
