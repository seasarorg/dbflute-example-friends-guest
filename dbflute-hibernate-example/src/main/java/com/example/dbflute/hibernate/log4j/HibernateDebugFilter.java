package com.example.dbflute.hibernate.log4j;

import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class HibernateDebugFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        Object messageObject = event.getMessage();
        if (messageObject != null) {
            String msg = messageObject.toString();
            if (msg.startsWith("returning ") && msg.contains(" as column: ")) {
                return DENY; // because it's too noisy
            }
        }
        return NEUTRAL;
    }
}
