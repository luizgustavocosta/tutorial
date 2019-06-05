package com.guga.behavioral.observer;


import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.spi.LoggingEvent;

public class ColorConsoleAppender extends ConsoleAppender {

    @Override
    protected void subAppend(final LoggingEvent event) {
        int color = 38;
        if (event.getRenderedMessage().contains("CellPhone")) {
            color = 32;
        } else if (event.getRenderedMessage().contains(SmartPhone.class.getName())) {
            color = 31;
        } else if (!event.getRenderedMessage().contains(SmartPhone.class.getName())) {
            color = 33;
        }
        qw.write("\u001b[0;" + color + "m");
        super.subAppend(event);
        qw.write("\u001b[m");
        if (this.immediateFlush) qw.flush();
    }
}
