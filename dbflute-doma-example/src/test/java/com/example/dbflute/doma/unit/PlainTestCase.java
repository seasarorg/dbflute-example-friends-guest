package com.example.dbflute.doma.unit;

import java.sql.Timestamp;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The test base of simple test.
 * @author jflute
 * @since 0.9.6.1 (2009/11/23 Monday)
 */
public abstract class PlainTestCase extends TestCase {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance for sub class. */
    private static final Log _log = LogFactory.getLog(PlainTestCase.class);

    // ===================================================================================
    //                                                                              Helper
    //                                                                              ======
    protected void log(Object msg) {
        _log.debug(msg);
    }

    protected Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
    
    protected static String getLineSeparator() {
        return System.getProperty("line.separator");
    }
}
