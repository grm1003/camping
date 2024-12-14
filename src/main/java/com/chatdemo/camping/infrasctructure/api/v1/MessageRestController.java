package com.chatdemo.camping.infrasctructure.api.v1;


import com.chatdemo.camping.domains.resourses.MessageSender;
import com.chatdemo.camping.infrasctructure.api.request.MessageRequest;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class MessageRestController {
    private final MessageSender messageSender;

    @GetMapping("/teste")
    public String teste() {
        return "Camping running";
    }

    @PostMapping("/sendMessage/{sender}")
    public void sendMessage(@RequestBody MessageRequest messageRequest, @PathVariable String sender) {
        messageSender.send(messageRequest.toModel(sender));
    }
}
