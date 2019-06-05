package com.guga.behavioral.observer;

import java.time.Instant;

class Message {

    private final String content;

    Message(String content) {
        this.content = content + " generated at "+ Instant.now();
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                '}';
    }
}