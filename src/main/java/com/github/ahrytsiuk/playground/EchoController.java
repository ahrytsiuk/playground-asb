package com.github.ahrytsiuk.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    private static final Logger log = LoggerFactory.getLogger(EchoController.class);
    private final StreamBridge streamBridge;

    public EchoController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping("/echo")
    public void register(@RequestParam(defaultValue = "test") String message) {
        log.info("/echo called with param=>{}", message);
        streamBridge.send("echoListener-out-0", message);
    }

}
