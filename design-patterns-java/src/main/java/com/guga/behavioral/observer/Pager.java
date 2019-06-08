package com.guga.behavioral.observer;

import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Pager extends ElectronicDevice {

    private AtomicInteger receivedMessages = new AtomicInteger();

    Pager() {
        log = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public void onNext(Message item) {
        logConsoleMessage("Bipi bibi I've  "+(receivedMessages.incrementAndGet())+" new messages.");
        subscription.request(1);
    }
}
