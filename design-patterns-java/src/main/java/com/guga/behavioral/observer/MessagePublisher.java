package com.guga.behavioral.observer;

import java.util.concurrent.Flow;

public class MessagePublisher implements Flow.Publisher<Message> {

    private boolean subscribed;

    @Override
    public void subscribe(Flow.Subscriber<? super Message> subscriber) {
        if (subscribed) {
        } else {
            subscribed = true;
            subscriber.onComplete();
        }
    }
}
