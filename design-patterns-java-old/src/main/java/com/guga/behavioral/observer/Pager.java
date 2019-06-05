package com.guga.behavioral.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class Pager implements CustomObserver {

    private static final Logger logger = LoggerFactory.getLogger(Pager.class);

    @Override
    public void update(Message message) {
        if (logger.isInfoEnabled()) {
            logger.info(
                    MessageFormat.format("{0} -> {1}",
                            "New message to Pager γάμμα (gamma)", message));
        }
    }
}
