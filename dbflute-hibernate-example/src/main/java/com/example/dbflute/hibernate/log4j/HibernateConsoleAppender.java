package com.example.dbflute.hibernate.log4j;

import org.apache.log4j.ConsoleAppender;

public class HibernateConsoleAppender extends ConsoleAppender {

    public HibernateConsoleAppender() {
        addFilter(new HibernateDebugFilter());
    }
}
