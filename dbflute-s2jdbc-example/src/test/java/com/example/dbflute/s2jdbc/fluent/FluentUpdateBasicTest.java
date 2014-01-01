package com.example.dbflute.s2jdbc.fluent;

import java.util.Date;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.exception.SEntityExistsException;
import org.seasar.framework.exception.SQLRuntimeException;

import com.example.dbflute.s2jdbc.entity.Member;
import com.example.dbflute.s2jdbc.unit.ContainerTestCase;

/**
 * @author jflute
 * @since 0.6.9 (2008/04/11)
 */
public class FluentUpdateBasicTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    public JdbcManager jdbcManager;

    // ===================================================================================
    //                                                                              Insert
    //                                                                              ======
    public void test_insert_Tx() throws Exception {
        // ## Arrange ##
        final Member member = new Member();
        member.memberId = 99999; // ignored
        member.memberName = "テストインサート";
        member.memberAccount = "test_insert";
        member.birthdate = new Date();
        member.formalizedDatetime = currentTimestamp();
        member.memberStatusCode = "FML";
        member.registerUser = "aaa";
        member.registerDatetime = currentTimestamp();
        member.updateUser = "aaa";
        member.updateDatetime = currentTimestamp();

        // ## Act ##
        final int insertedCount = jdbcManager.insert(member).execute();

        // ## Assert ##
        assertEquals(1, insertedCount);
        final Member actual = jdbcManager.from(Member.class).id(member.memberId).getSingleResult();
        log(actual);
        assertNotNull(actual.memberId);
        assertEquals(member.memberName, actual.memberName);
    }

    public void test_insert_unique_constraint_Tx() throws Exception {
        // ## Arrange ##
        final Member member = new Member();
        member.memberName = "テストインサート";
        member.memberAccount = "test_insert";
        member.birthdate = new Date();
        member.formalizedDatetime = currentTimestamp();
        member.memberStatusCode = "FML";
        member.registerUser = "aaa";
        member.registerDatetime = currentTimestamp();
        member.updateUser = "aaa";
        member.updateDatetime = currentTimestamp();

        // ## Act & Assert ##
        jdbcManager.insert(member).execute();
        try {
            jdbcManager.insert(member).execute();
            fail();
        } catch (SEntityExistsException e) {
            log("/* * * * * * * * * * * * * * * * * * *");
            log("Exception = " + e.getClass().getName());
            log("Message   = " + e.getMessage());
            log("* * * * * * * * * */");
        }
    }

    public void test_insert_notnull_constraint_Tx() throws Exception {
        // ## Arrange ##
        final Member member = new Member();
        // member.memberName = "テストインサート";
        member.memberAccount = "test_insert";
        member.birthdate = new Date();
        member.formalizedDatetime = currentTimestamp();
        member.memberStatusCode = "FML";
        member.registerUser = "aaa";
        member.registerDatetime = currentTimestamp();
        member.updateUser = "aaa";
        member.updateDatetime = currentTimestamp();

        // ## Act & Assert ##
        try {
            jdbcManager.insert(member).execute();
            fail();
        } catch (SQLRuntimeException e) {
            log("/* * * * * * * * * * * * * * * * * * *");
            log("Exception = " + e.getClass().getName());
            log("Message   = " + e.getMessage());
            log("* * * * * * * * * */");
        }
    }

    // ===================================================================================
    //                                                                              Update
    //                                                                              ======
    public void test_update_Tx() throws Exception {
        // ## Arrange ##
        final Member member = jdbcManager.from(Member.class).id(3).getSingleResult();
        member.memberName = "テストアップデート";
        member.memberAccount = "test_update";

        // ## Act ##
        final int updatedCount = jdbcManager.update(member).execute();

        // ## Assert ##
        assertEquals(1, updatedCount);
        final Member actual = jdbcManager.from(Member.class).id(member.memberId).getSingleResult();
        log(actual);
        assertEquals(member.memberName, actual.memberName);
        assertEquals(member.memberAccount, actual.memberAccount);
    }

    public void test_update_includes_Tx() throws Exception {
        // ## Arrange ##
        final Member member = jdbcManager.from(Member.class).id(3).getSingleResult();
        member.memberName = "テストアップデート";
        member.memberAccount = "test_update";
        member.versionNo = 0L;

        // ## Act ##
        final int updatedCount = jdbcManager.update(member).includes("memberName").execute();

        // ## Assert ##
        assertEquals(1, updatedCount);
        final Member actual = jdbcManager.from(Member.class).id(member.memberId).getSingleResult();
        log(actual);
        assertEquals(member.memberName, actual.memberName);
        assertNotSame(member.memberAccount, actual.memberAccount);
        assertNotSame(0L, member.versionNo); // Not increment about versionNo on Entity.
    }

    public void test_update_includesVersion_Tx() throws Exception {
        // ## Arrange ##
        final Member member = jdbcManager.from(Member.class).id(3).getSingleResult();
        member.memberName = "テストアップデート";
        member.memberAccount = "test_update";
        member.versionNo = 123L;

        // ## Act ##
        final int updatedCount = jdbcManager.update(member).includesVersion().execute();

        // ## Assert ##
        assertEquals(1, updatedCount);
        final Member actual = jdbcManager.from(Member.class).id(member.memberId).getSingleResult();
        log(actual);
        assertEquals(member.memberName, actual.memberName);
        assertEquals(member.memberAccount, actual.memberAccount);
        assertEquals(member.versionNo, actual.versionNo);
    }
}
