package com.chatdemo.camping.domains.models;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserMessage {
    private String senderCode;
    private String message;
    private TypeMessageEnum type;
    private List<String> receiversCodes;

}
