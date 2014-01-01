package com.example.dbflute.hibernate.dbflute;

import java.util.List;

import com.example.dbflute.hibernate.dbflute.exentity.Member;
import com.example.dbflute.hibernate.dbflute.exentity.MemberStatus;
import com.example.dbflute.hibernate.dbflute.exentity.MemberWithdrawal;
import com.example.dbflute.hibernate.dbflute.exentity.Purchase;
import com.example.dbflute.hibernate.unit.ContainerTestCase;

/**
 * @author jflute
 * @since 0.9.5.2 (2009/07/11 Saturday)
 */
public class SelectTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                       Select Entity
    //                                                                       =============
    public void test_find_Member_Tx() throws Exception {
        // ## Arrange ##
        logArrange();

        // ## Act ##
        logAct();
        keepBeforeTime();
        Member member = find(Member.class, 1);
        keepAfterTime();

        // ## Assert ##
        logAssert();
        log(getLineSeparator() + member.toStringWithRelation());
        showPerformanceCost();
        assertEquals(Integer.valueOf(1), member.getMemberId());
        assertTrue(member.isMemberStatusCodeFormalized());
        assertNull(member.getMemberWithdrawalAsOne());
    }

    public void test_find_Purchase_Tx() throws Exception {
        // ## Arrange ##
        logArrange();

        // ## Act ##
        logAct();
        keepBeforeTime();
        Purchase purchase = find(Purchase.class, 3L);
        keepAfterTime();

        // ## Assert ##
        logAssert();
        log(getLineSeparator() + purchase.toStringWithRelation());
        showPerformanceCost();
        assertEquals(Long.valueOf(3), purchase.getPurchaseId());
    }

    public void test_find_MemberWithdrawal_Tx() throws Exception {
        // ## Arrange ##
        logArrange();

        // ## Act ##
        logAct();
        keepBeforeTime();
        MemberWithdrawal withdrawal = find(MemberWithdrawal.class, 3);
        keepAfterTime();

        // ## Assert ##
        logAssert();
        log(getLineSeparator() + withdrawal.toStringWithRelation());
        showPerformanceCost();
        assertEquals(Integer.valueOf(3), withdrawal.getMemberWithdrawalId());
    }

    // ===================================================================================
    //                                                                         Select List
    //                                                                         ===========
    public void test_findAll_Member_Tx() throws Exception {
        // ## Arrange ##
        logArrange();

        // ## Act ##
        logAct();
        keepBeforeTime();
        List<Member> memberList = findAll(Member.class);
        keepAfterTime();

        // ## Assert ##
        logAssert();
        final StringBuilder sb = new StringBuilder();
        for (Member member : memberList) {
            sb.append(getLineSeparator()).append(member.toStringWithRelation());
        }
        log(sb.toString());
        showPerformanceCost();
    }

    public void test_find_one_to_many_to_many_Tx() throws Exception {
        // ## Arrange ##
        logArrange();

        String hql = "from " + MemberStatus.class.getName() + " ms";
        hql = hql + " left outer join ms.memberList mb";
        hql = hql + " left outer join fetch mb.memberWithdrawalAsOne mwd";
        hql = hql + " left outer join fetch mb.memberSecurityAsOne msc";
        hql = hql + " left outer join mb.purchaseList pc";

        // ## Act ##
        logAct();
        keepBeforeTime();
        @SuppressWarnings("unchecked")
        List<MemberStatus> resultList = (List<MemberStatus>) entityManager.createQuery(hql).getResultList();
        keepAfterTime();

        // ## Assert ##
        logAssert();
        final StringBuilder sb = new StringBuilder();

        log(resultList);
        Object obj = resultList.get(0);
        log("obj=" + obj.getClass());

        try {
            for (MemberStatus memberStatus : resultList) {
                final List<Member> memberList = memberStatus.getMemberList();
                sb.append(getLineSeparator()).append(memberStatus.getMemberStatusName());
                for (Member member : memberList) {
                    sb.append(getLineSeparator()).append("  ").append(member.getMemberName());
                    List<Purchase> purchaseList = member.getPurchaseList();
                    for (Purchase purchase : purchaseList) {
                        sb.append(getLineSeparator()).append("    ").append(purchase.getPurchaseId());
                        sb.append(", ").append(purchase.getPurchasePrice());
                    }
                }
            }
            log(sb.toString());
            showPerformanceCost();
        } catch (ClassCastException e) {
            // why?
            log(e.getMessage());
        }
    }
}
