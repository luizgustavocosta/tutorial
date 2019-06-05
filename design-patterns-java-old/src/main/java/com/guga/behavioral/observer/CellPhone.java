package com.guga.behavioral.observer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class CellPhone implements CustomObserver{

    private static final Logger logger = LoggerFactory.getLogger(CellPhone.class);

    @Override
    public void update(Message message) {
        if (logger.isInfoEnabled()) {
            logger.info(MessageFormat.format("{0} -> {1}",
                    "New message to CellPhone άλφα (Alpha)",
                    message));
        }
    }

}
