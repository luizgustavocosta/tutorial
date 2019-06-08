package com.guga.behavioral.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppMain {

    private static final Logger logger = LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("Init");
        MessagePublisher<Message> publisher = new MessagePublisher<>();

        final CellPhone cellPhone = new CellPhone();
        final SmartPhone smartPhone = new SmartPhone();
        final Pager pager = new Pager();
        Stream.of(cellPhone, smartPhone, pager)
                .forEach(publisher::subscribe);

        logger.info("Subscribers added");
        logger.info("Creating messages");

        Stream.iterate(1, n -> n + 1)
                .parallel()
                .map(n -> new Message("Message "+n))
                .limit(10)
                .collect(Collectors.toList())
                .forEach(publisher::submit);
        try {
            logger.info("Wait 1_000 millis....");
            Thread.sleep(1_000);
        } catch (InterruptedException exception) {
            logger.error("Error ", exception);
            throw exception;
        }

        logger.info("Let's cancel the subscription to electronic device Pager");
        pager.getSubscription().cancel();
        publisher.submit(new Message("Other message"));

        logger.info("Let's close the publisher");
        publisher.close();

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException exception) {
            logger.error("Error ", exception);
            throw exception;
        }
    }
}
