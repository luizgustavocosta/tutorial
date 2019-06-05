package com.guga.behavioral.observer;

import org.slf4j.LoggerFactory;

import java.util.concurrent.SubmissionPublisher;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppMain {


    private static final org.slf4j.Logger logger = LoggerFactory.
            getLogger(AppMain.class);

    public static void main(String[] args) {
        logger.info("Init");
        SubmissionPublisher<Message> publisher = new SubmissionPublisher<>();

        Stream.of(new CellPhone(), new SmartPhone())
                .forEach(publisher::subscribe);

        logger.info("Subscribers added");

        logger.info("Creating messages");

        Stream.iterate(1, n -> n + 1)
                .map(m -> new Message("Message "+m))
                .limit(10)
                .collect(Collectors.toList())
                /*.forEach(message -> publisher.offer(message, 10, TimeUnit.SECONDS,
                        (subscriber, messageConsumer) -> {
                            subscriber.onError(
                                    new RuntimeException("Hey " + subscriber +
                                            "something bad happened"));
                            return false;}));
                */
                .forEach(publisher::submit);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        publisher.close();
    }
}
