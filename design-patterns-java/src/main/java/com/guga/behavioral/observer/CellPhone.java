package com.guga.behavioral.observer;

import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.concurrent.Flow;

public class CellPhone<T> implements Flow.Subscriber<T> {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CellPhone.class);

    private Flow.Subscription subscription;
    private int count = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        ++count;
        log("Message "+count+" arrived at CellPhone");
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("New error on CellPhone", throwable);
    }

    @Override
    public void onComplete() {
        log.info("It is done");
    }

    private void log(final String logMessage) {
        //if (log.isInfoEnabled()) {
            log.info(MessageFormat.format("{0}{1}","<=========== : " , logMessage));
        //}
    }
}
