package com.example.dbflute.hibernate.dbflute;

import javax.persistence.EntityExistsException;

import com.example.dbflute.hibernate.dbflute.allcommon.CDef;
import com.example.dbflute.hibernate.dbflute.exentity.Member;
import com.example.dbflute.hibernate.dbflute.exentity.MemberStatus;
import com.example.dbflute.hibernate.unit.ContainerTestCase;

/**
 * @author jflute
 * @since 0.9.5.2 (2009/07/23 Thursday)
 */
public class UpdateTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                       Insert Entity
    //                                                                       =============
    public void test_persist_plain_Tx() throws Exception {
        // ## Arrange ##
        logArrange();
        final MemberStatus memberStatus = new MemberStatus();
        memberStatus.setMemberStatusCode("TST");
        memberStatus.setMemberStatusName("TestStatus");
        memberStatus.setDisplayOrder(99);

        // ## Act ##
        logAct();
        keepBeforeTime();
        persist(memberStatus);
        keepAfterTime();
        flush();

        // ## Assert ##
        logAssert();
        MemberStatus actual = find(MemberStatus.class, "TST");
        showPerformanceCost();
        log("actual=" + actual);
        assertEquals("TST", actual.getMemberStatusCode());
    }

    public void test_persist_with_classification_and_commonColumn_Tx() throws Exception {
        // ## Arrange ##
        logArrange();
        final Member member = new Member();
        member.setMemberId(99999); // ignored
        member.setMemberName("TestName");
        member.setMemberAccount("TestAccount");
        member.classifyMemberStatusCodeFormalized();

        // ## Act ##
        logAct();
        keepBeforeTime();
        persist(member);
        keepAfterTime();
        flush();

        // ## Assert ##
        logAssert();
        Member actual = find(Member.class, member.getMemberId());
        showPerformanceCost();
        log("actual=" + actual);
        assertEquals(accessUser, actual.getRegisterUser());
        assertEquals(accessUser, actual.getUpdateUser());
        assertEquals(CDef.MemberStatus.Formalized, actual.getMemberStatusCodeAsMemberStatus());
    }

    public void test_persist_uniqueConstraint_Tx() throws Exception {
        // ## Arrange ##
        logArrange();
        final MemberStatus memberStatus = new MemberStatus();
        memberStatus.setMemberStatusCode("FML");
        memberStatus.setMemberStatusName("Test");
        memberStatus.setDisplayOrder(99);

        // ## Act ##
        logAct();
        keepBeforeTime();
        persist(memberStatus);
        keepAfterTime();
        try {
            flush();

            // ## Assert ##
            fail();
        } catch (EntityExistsException e) {
            // OK
            logAssert();
            log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                       Update Entity
    //                                                                       =============
    public void test_update_with_classification_and_commonColumn_Tx() throws Exception {
        // ## Arrange ##
        logArrange();
        final Member member = find(Member.class, 3);
        assertNotSame(accessUser, member.getRegisterUser());
        assertNotSame(accessUser, member.getUpdateUser());

        // ## Act ##
        logAct();
        keepBeforeTime();
        member.setMemberName("TestName");
        member.setMemberAccount("TestAccount");
        member.classifyMemberStatusCodeProvisional();
        member.setFormalizedDatetime(null);
        keepAfterTime();
        flush();

        // ## Assert ##
        logAssert();
        Member actual = find(Member.class, member.getMemberId());
        showPerformanceCost();
        log("actual=" + actual);
        assertNotSame(accessUser, actual.getRegisterUser());
        assertEquals(accessUser, actual.getUpdateUser());
        assertEquals(CDef.MemberStatus.Provisional, actual.getMemberStatusCodeAsMemberStatus());
        assertNull(actual.getFormalizedDatetime());
    }
}
