package com.guga.behavioral.observer;

import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class SmartPhone extends ElectronicDevice {

    private AtomicInteger receivedMessages = new AtomicInteger();

    SmartPhone() {
        log = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public void onNext(Message item) {
        logConsoleMessage("Reflection Reflection I've "+(receivedMessages.incrementAndGet())+" new messages.");
        subscription.request(1);
    }
}
