package com.example.dbflute.doma;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.Sql;
import org.seasar.doma.jdbc.SqlExecutionSkipCause;

/**
 * @author jflute (refers to doma-jpetstore)
 * @since 0.9.6.1 (2009/11/24 Tuesday)
 */
public class CommonsJdbcLogger implements JdbcLogger {

    @Override
    public void logConnectionClosingFailure(String callerClassName, String callerMethodName, SQLException e) {
    }

    @Override
    public void logStatementClosingFailure(String callerClassName, String callerMethodName, SQLException e) {
    }

    @Override
    public void logResultSetClosingFailure(String callerClassName, String callerMethodName, SQLException e) {
    }

    @Override
    public void logDaoMethodEntering(String callerClassName, String callerMethodName, Object... parameters) {
        Log log = LogFactory.getLog(callerClassName);
        log.info("START " + callerClassName + "#" + callerMethodName);
    }

    @Override
    public void logDaoMethodExiting(String callerClassName, String callerMethodName, Object result) {
        Log log = LogFactory.getLog(callerClassName);
        log.info("END   " + callerClassName + "#" + callerMethodName);
    }

    @Override
    public void logSqlExecutionSkipping(String callerClassName, String callerMethodName, SqlExecutionSkipCause cause) {
        Log log = LogFactory.getLog(callerClassName);
        log.info("SKIPPED(" + cause.name() + ") " + callerClassName + "#" + callerMethodName);
    }

    @Override
    public void logSql(String callerClassName, String callerMethodName, Sql<?> sql) {
        Log log = LogFactory.getLog(callerClassName);
        String message = String.format("SQL log. sqlFilePath=[%s],%n%s", sql.getSqlFilePath(), sql.getFormattedSql());
        log.info(message);
    }
}