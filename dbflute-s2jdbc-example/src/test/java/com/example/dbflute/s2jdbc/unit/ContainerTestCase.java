package com.example.dbflute.s2jdbc.unit;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.extension.unit.S2TestCase;

/**
 * The test base of application for Basic Example.
 * 
 * @author jflute
 * @since 0.5.6 (2007/10/22 Monday)
 */
public abstract class ContainerTestCase extends S2TestCase {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance for sub class. */
    private static final Log _log = LogFactory.getLog(ContainerTestCase.class);

    // ===================================================================================
    //                                                                            Settings
    //                                                                            ========
    @Override
    public void setUp() {
        include("app.dicon");
    }

    // ===================================================================================
    //                                                                              Helper
    //                                                                              ======
    protected void log(Object msg) {
        _log.debug(msg);
    }

    protected Date currentDate() {
        return new Date(System.currentTimeMillis());
    }

    protected Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    protected static String getLineSeparator() {
        return System.getProperty("line.separator");
    }
}
