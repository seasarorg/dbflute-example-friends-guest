package com.example.dbflute.hibernate.unit;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.extension.unit.S2TestCase;

import com.example.dbflute.hibernate.dbflute.allcommon.AccessContext;
import com.example.dbflute.hibernate.dbflute.allcommon.CDef;
import com.example.dbflute.hibernate.dbflute.allcommon.Entity;

/**
 * The test base of application for Basic Example.
 * 
 * @author jflute
 * @since 0.9.5.2 (2009/07/11 Saturday)
 */
public abstract class ContainerTestCase extends S2TestCase {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance for sub class. */
    private static final Log _log = LogFactory.getLog(ContainerTestCase.class);

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected EntityManager entityManager;
    protected Timestamp accessTimestamp;
    protected String accessUser;
    protected String accessProcess;
    protected Long before;
    protected Long after;

    // ===================================================================================
    //                                                                            Settings
    //                                                                            ========
    @Override
    public void setUp() {
        include("app.dicon");

        initializeAccessContext();
    }

    protected void initializeAccessContext() {
        accessTimestamp = currentTimestamp();
        accessUser = "testUser";
        accessProcess = getClass().getSimpleName();
        AccessContext context = new AccessContext();
        context.setAccessTimestamp(accessTimestamp);
        context.setAccessUser(accessUser);
        context.setAccessProcess(accessProcess);
        AccessContext.setAccessContextOnThread(context);
    }

    @Override
    public void tearDown() {
        destroyAccessContext();
    }

    protected void destroyAccessContext() {
        AccessContext.clearAccessContextOnThread();
    }

    // ===================================================================================
    //                                                                    DB Access Helper
    //                                                                    ================
    protected <T extends Entity> T find(Class<T> entityClass, Object primaryKey) {
        if (primaryKey instanceof CDef) {
            primaryKey = ((CDef) primaryKey).code();
        }
        return entityManager.find(entityClass, primaryKey);
    }

    protected <T extends Entity> List<T> findAll(Class<T> entityClass) {
        return findAll(entityClass, null);
    }

    protected <T extends Entity> List<T> findAll(Class<T> entityClass, String orderByString) {
        String qlString = "from " + entityClass.getName();
        if (orderByString != null && orderByString.trim().length() > 0) {
            qlString += " order by " + orderByString;
        }
        @SuppressWarnings("unchecked")
        List<T> resultList = (List<T>) entityManager.createQuery(qlString).getResultList();
        return resultList;
    }

    protected void persist(Entity entity) {
        entityManager.persist(entity);
    }

    protected void flush() {
        entityManager.flush();
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    protected void logArrange() {
        log("==========================================================================================");
        log("                                                                                   Arrange");
        log("                                                                                   =======");
    }

    protected void logAct() {
        log("==========================================================================================");
        log("                                                                                       Act");
        log("                                                                                       ===");
    }

    protected void logAssert() {
        log("==========================================================================================");
        log("                                                                                    Assert");
        log("                                                                                    ======");
    }

    protected void keepBeforeTime() {
        log("...Keeping before-time");
        before = currentTimeMillis();
    }

    protected void keepAfterTime() {
        log("...Keeping after-time");
        after = currentTimeMillis();
    }

    protected void showPerformanceCost() {
        if (before != null && after != null) {
            log("/- - - - - - - - - - - - - - - -");
            log("[Performance Cost]: " + convertToPerformanceView(after - before));
            log("- - - - - - - - - -/");
        }
    }

    /**
     * Convert to performance view.
     * @param afterMinusBefore The value of after-minus-before millisecond.
     * @return Performance view. (ex. 1m23s456ms) (NotNull)
     */
    protected String convertToPerformanceView(long afterMinusBefore) {
        if (afterMinusBefore < 0) {
            return String.valueOf(afterMinusBefore);
        }

        long sec = afterMinusBefore / 1000;
        final long min = sec / 60;
        sec = sec % 60;
        final long mil = afterMinusBefore % 1000;

        final StringBuffer sb = new StringBuffer();
        if (min >= 10) { // Minute
            sb.append(min).append("m");
        } else if (min < 10 && min >= 0) {
            sb.append("0").append(min).append("m");
        }
        if (sec >= 10) { // Second
            sb.append(sec).append("s");
        } else if (sec < 10 && sec >= 0) {
            sb.append("0").append(sec).append("s");
        }
        if (mil >= 100) { // Millisecond
            sb.append(mil).append("ms");
        } else if (mil < 100 && mil >= 10) {
            sb.append("0").append(mil).append("ms");
        } else if (mil < 10 && mil >= 0) {
            sb.append("00").append(mil).append("ms");
        }

        return sb.toString();
    }

    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    protected void log(Object msg) {
        _log.debug(msg);
    }

    protected long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    protected Date currentDate() {
        return new Date();
    }

    protected Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    protected static String getLineSeparator() {
        return System.getProperty("line.separator");
    }
}
