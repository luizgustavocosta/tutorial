package com.guga.behavioral.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class MessagePublisher implements Subject {

    private static final Logger logger = LoggerFactory.getLogger(MessagePublisher.class);

    private List<CustomObserver> observers = new ArrayList<>();

    @Override
    public void attach(CustomObserver observer) {
        observers.add(observer);
        if (logger.isInfoEnabled()) {
            logger.info(MessageFormat.format(
                    "{0} + {1}",
                    "Attached the observer ",
                    observer.getClass().getSimpleName()));
        }
    }

    @Override
    public void detach(CustomObserver observer) {
        observers.remove(observer);
        logger.info(
                "Detached the observer "+observer.getClass().getSimpleName());
    }

    @Override
    public void update(Message message) {
        observers.forEach(observer ->  observer.update(message));
    }
}
