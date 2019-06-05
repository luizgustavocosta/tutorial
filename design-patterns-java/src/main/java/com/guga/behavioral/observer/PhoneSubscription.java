package com.guga.behavioral.observer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;
import java.util.concurrent.Future;

public class PhoneSubscription implements Flow.Subscription {

    private final Flow.Subscriber<? super Message> subscriber;
    private final ExecutorService executor;
    private Future<?> future; // to allow cancellation
    private boolean completed;

    public PhoneSubscription(Flow.Subscriber<? super Message> subscriber,
                             ExecutorService executor) {
        this.subscriber = subscriber;
        this.executor = executor;
    }

    @Override
    public void request(long n) {
        if (n != 0 && !completed) {
            completed = true;
            if (n < 0) {
                IllegalArgumentException ex = new IllegalArgumentException();
                executor.execute(() -> subscriber.onError(ex));
            } else {
                future = executor.submit(() -> {
                    subscriber.onNext(new Message("Message "+n));
                    subscriber.onComplete();
                });
            }
        }
    }

    @Override
    public void cancel() {
        completed = true;
        if (future != null) future.cancel(false);
    }
}
