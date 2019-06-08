package com.guga.behavioral.observer;

import java.util.concurrent.SubmissionPublisher;

public class MessagePublisher<Message> extends SubmissionPublisher<Message> {

    @Override
    public int submit(Message item) {
        return super.submit(item);
    }
}
