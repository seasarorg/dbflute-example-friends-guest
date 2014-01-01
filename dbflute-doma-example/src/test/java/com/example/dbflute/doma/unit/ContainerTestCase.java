package com.example.dbflute.doma.unit;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.example.dbflute.doma.AppDomaConfig;
import com.example.dbflute.doma.AppDomaModule;
import com.google.inject.AbstractModule;
import com.google.inject.Module;

/**
 * The test case with container.
 * @author jflute
 * @since 0.9.6.1 (2009/11/23 Monday)
 */
public abstract class ContainerTestCase extends AppGuiceTestCase {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance. */
    private static final Log _log = LogFactory.getLog(ContainerTestCase.class);

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                    Transaction Object
    //                                    ------------------
    /** The transaction manager for platform. {Transaction Object} */
    protected TransactionManager transactionManager;

    // -----------------------------------------------------
    //                                           Data Source
    //                                           -----------
    /** The data source for database connection. */
    protected DataSource dataSource;

    /** The application configuration of DOMA. */
    protected AppDomaConfig appDomaConfig = new AppDomaConfig();

    // ===================================================================================
    //                                                                            Settings
    //                                                                            ========
    @Override
    public void setUp() {
        setupDataSource();
        super.setUp(); // is initializing the container
    }

    protected void setupDataSource() {
        dataSource = createDataSource();
    }

    protected DataSource createDataSource() {
        return appDomaConfig.getDataSource();
    }

    @Override
    protected void setupApplicationModule(List<Module> moduleList) {
        moduleList.add(new AppDomaModule());
    }

    @Override
    protected void setupTransactionModule(List<Module> moduleList) {
        moduleList.add(new TransactionModule(dataSource));
    }

    protected static class TransactionModule extends AbstractModule {

        protected DataSource dataSource;

        public TransactionModule(DataSource dataSource) {
            if (dataSource == null) {
                String msg = "The argument 'dataSource' should not be null!";
                throw new IllegalArgumentException(msg);
            }
            this.dataSource = dataSource;
        }

        @Override
        protected void configure() {
            try {
                UserTransactionImp userTransactionImp = new UserTransactionImp();
                userTransactionImp.setTransactionTimeout(300);
                UserTransactionManager userTransactionManager = new UserTransactionManager();
                userTransactionManager.setForceShutdown(true);
                userTransactionManager.init();
                bind(UserTransaction.class).toInstance(userTransactionImp);
                bind(TransactionManager.class).toInstance(userTransactionManager);

                bind(DataSource.class).toInstance(dataSource);
            } catch (SystemException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @Override
    protected void beginTransaction() {
        try {
            transactionManager.begin();
        } catch (NotSupportedException e) {
            throw new IllegalStateException(e);
        } catch (SystemException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Override
    protected void rollbackTransaction() {
        try {
            transactionManager.rollback();
        } catch (SystemException e) {
            throw new IllegalStateException(e);
        }
    }

    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
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
        return "\n";
    }
}
