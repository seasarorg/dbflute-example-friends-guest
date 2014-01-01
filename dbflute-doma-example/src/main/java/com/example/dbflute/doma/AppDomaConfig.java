package com.example.dbflute.doma;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.StandardDialect;

import com.atomikos.jdbc.nonxa.AtomikosNonXADataSourceBean;

/**
 * @author jflute
 * @since 0.9.6.1 (2009/11/23 Monday)
 */
public class AppDomaConfig extends DomaAbstractConfig {

    private static DataSource dataSource = createDataSource();

    private static Dialect dialect = createDialect();

    private static JdbcLogger logger = createJdbcLogger();

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    @Override
    public JdbcLogger getJdbcLogger() {
        return logger;
    }

    private static DataSource createDataSource() {
        AtomikosNonXADataSourceBean bean = new AtomikosNonXADataSourceBean();
        bean.setUniqueResourceName("NONXADBMS");
        bean.setDriverClassName("org.h2.jdbcx.JdbcDataSource");
        EmbeddedH2UrlFactoryBean factoryBean = new EmbeddedH2UrlFactoryBean();
        factoryBean.setUrlSuffix("/exampledb/exampledb");
        factoryBean.setReferenceClassName(AppDomaConfig.class.getName());
        String url;
        try {
            url = factoryBean.getObject().toString();
        } catch (Exception e) {
            String msg = "The factoryBean was invalid: " + factoryBean;
            throw new IllegalStateException(msg, e);
        }
        bean.setUrl(url.toString());
        bean.setUser("sa");
        bean.setPassword("");
        bean.setPoolSize(20);
        bean.setBorrowConnectionTimeout(60);
        return bean;
    }

    private static JdbcLogger createJdbcLogger() {
        return new CommonsJdbcLogger();
    }

    private static Dialect createDialect() {
        return new StandardDialect();
    }
}