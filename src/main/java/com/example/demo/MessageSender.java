package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
@Slf4j
public class MessageSender {

    private final Source source;

    @Autowired
    public MessageSender(Source source) {
        this.source = source;
    }

    public boolean send(String message) {
        log.info("message {}", message);
        return source.output().send(MessageBuilder.withPayload(message).build());
    }
}
