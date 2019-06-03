package com.guga.behavioral.observer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class CellPhone implements CustomObserver{

    private static final Logger logger = LoggerFactory.getLogger(CellPhone.class);

    @Override
    public void notifyObservers(Message message) {
        if (logger.isInfoEnabled()) {
            log(MessageFormat.format("{0} -> {1}",
                    "New message to CellPhone άλφα (Alpha)",
                    message));
        }
    }

    private void log(final String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }
}
