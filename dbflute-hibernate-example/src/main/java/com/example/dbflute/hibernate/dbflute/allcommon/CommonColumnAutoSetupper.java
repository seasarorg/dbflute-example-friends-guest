package com.example.dbflute.hibernate.dbflute.allcommon;

/**
 * The auto set-upper of common column.
 * @author DBFlute(AutoGenerator)
 */
public class CommonColumnAutoSetupper {

    // =====================================================================================
    //                                                                                Set up
    //                                                                                ======
    /**
     * Handle common columns of insert if it needs.
     * @param targetEntity Target entity that the type is entity interface. (NotNull)
     */
    public void handleCommonColumnOfInsertIfNeeds(Entity targetEntity) {
        if (!(targetEntity instanceof EntityDefinedCommonColumn)) {
            return;
        }
        final EntityDefinedCommonColumn entity = (EntityDefinedCommonColumn)targetEntity;
        if (!entity.canCommonColumnAutoSetup()) {
            return;
        }

        final java.sql.Timestamp registerDatetime = com.example.dbflute.hibernate.dbflute.allcommon.AccessContext.getAccessTimestampOnThread();
        entity.setRegisterDatetime(registerDatetime);

        final String registerUser = com.example.dbflute.hibernate.dbflute.allcommon.AccessContext.getAccessUserOnThread();
        entity.setRegisterUser(registerUser);

        final String registerProcess = com.example.dbflute.hibernate.dbflute.allcommon.AccessContext.getAccessProcessOnThread();
        entity.setRegisterProcess(registerProcess);

        final java.sql.Timestamp updateDatetime = entity.getRegisterDatetime();
        entity.setUpdateDatetime(updateDatetime);

        final String updateUser = entity.getRegisterUser();
        entity.setUpdateUser(updateUser);

        final String updateProcess = entity.getRegisterProcess();
        entity.setUpdateProcess(updateProcess);
    }

    /**
     * Handle common columns of update if it needs.
     * @param targetEntity Target entity that the type is entity interface. (NotNull)
     */
    public void handleCommonColumnOfUpdateIfNeeds(Entity targetEntity) {
        if (!(targetEntity instanceof EntityDefinedCommonColumn)) {
            return;
        }
        final EntityDefinedCommonColumn entity = (EntityDefinedCommonColumn)targetEntity;
        if (!entity.canCommonColumnAutoSetup()) {
            return;
        }

        final java.sql.Timestamp updateDatetime = com.example.dbflute.hibernate.dbflute.allcommon.AccessContext.getAccessTimestampOnThread();
        entity.setUpdateDatetime(updateDatetime);

        final String updateUser = com.example.dbflute.hibernate.dbflute.allcommon.AccessContext.getAccessUserOnThread();
        entity.setUpdateUser(updateUser);

        final String updateProcess = com.example.dbflute.hibernate.dbflute.allcommon.AccessContext.getAccessProcessOnThread();
        entity.setUpdateProcess(updateProcess);
    }
}
