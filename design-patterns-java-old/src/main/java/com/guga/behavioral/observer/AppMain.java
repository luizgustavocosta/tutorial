package com.guga.behavioral.observer;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class AppMain {

    private static final Logger logger = LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("Initialize observer pattern");

        MessagePublisher messagePublisher = new MessagePublisher();

        CustomObserver cellPhone = new CellPhone();
        CustomObserver smartPhone = new SmartPhone();
        CustomObserver pager = new Pager();

        Stream.of(cellPhone, smartPhone, pager).forEach(messagePublisher::attach);

        messagePublisher.update(new Message("First message"));

        messagePublisher.detach(pager);

        messagePublisher.update(new Message("Second message"));
    }

}
