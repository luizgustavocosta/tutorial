package com.guga.behavioral.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Flow;

public class SmartPhone implements Flow.Subscriber<Message> {

    private final Logger logger = LoggerFactory.getLogger(SmartPhone.class);

    private String message;
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;

    }

    @Override
    public void onNext(Message item) {
        logger.info("New message "+item);
        subscription.request(1);

    }

    @Override
    public void onError(Throwable throwable) {
        logger.error("New error on CellPhone", throwable);
    }

    @Override
    public void onComplete() {
        logger.info("It is done");
    }
}
