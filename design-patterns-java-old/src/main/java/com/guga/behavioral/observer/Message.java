package com.guga.behavioral.observer;

import java.time.Instant;
import java.util.Observable;

class Message extends Observable {

    private final String content;

    Message(String content) {
        this.content = content + " generated at "+ Instant.now();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                '}';
    }
}
