package com.guga.behavioral.observer;

import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class CellPhone extends ElectronicDevice {

    private AtomicInteger receivedMessages = new AtomicInteger();

    CellPhone() {
        log = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public void onNext(Message item) {
        logConsoleMessage("Hello Moto I've  "+(receivedMessages.incrementAndGet())+" new messages.");
        subscription.request(1);
    }

}
