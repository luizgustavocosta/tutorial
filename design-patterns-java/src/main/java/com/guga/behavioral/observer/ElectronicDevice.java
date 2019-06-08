package com.guga.behavioral.observer;

import org.slf4j.Logger;

import java.util.concurrent.Flow;

public abstract class ElectronicDevice implements Flow.Subscriber<Message> {

    static Logger log;

    Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(10);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("New error on CellPhone", throwable);
    }

    @Override
    public void onComplete() {
        if (log.isInfoEnabled()) {
            log.info(String.format("%s%s", "Subscription complete for ",this.getClass().getSimpleName()));
        }
    }

    void logConsoleMessage(final String logMessage) {
        if (log.isInfoEnabled()) {
            log.info(String.format("%-15s%s", this.getClass().getSimpleName(), logMessage));
        }
    }

    Flow.Subscription getSubscription() {
        return subscription;
    }
}
