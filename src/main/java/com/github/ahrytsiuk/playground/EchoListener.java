package com.github.ahrytsiuk.playground;

import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class EchoListener implements Consumer<Message<String>> {

    private static final Logger log = LoggerFactory.getLogger(EchoListener.class);

    @Override
    public void accept(Message<String> message) {
        log.info("New message received: '{}'", message.getPayload());
    }

}
