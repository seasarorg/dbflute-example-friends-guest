package com.example.dbflute.s2jdbc.fluent;

import java.util.Date;
import java.util.List;

import org.seasar.extension.jdbc.JdbcManager;

import com.example.dbflute.s2jdbc.entity.Member;
import com.example.dbflute.s2jdbc.entity.MemberAddress;
import com.example.dbflute.s2jdbc.entity.MemberLogin;
import com.example.dbflute.s2jdbc.entity.Purchase;
import com.example.dbflute.s2jdbc.unit.ContainerTestCase;
import com.example.dbflute.s2jdbc.unit.TraceViewUtil;

/**
 * @author jflute
 * @since 0.6.9 (2008/04/11)
 */
public class FluentSelectBasicTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    public JdbcManager jdbcManager;

    // ===================================================================================
    //                                                                       Select Entity
    //                                                                       =============
    public void test_selectEntity_Tx() throws Exception {
        // ## Arrange ##
        final Integer memberId = 3;

        // ## Act ##
        long before = currentDate().getTime();
        final Member member = jdbcManager.from(Member.class).where("memberId = ?", memberId).getSingleResult();
        long after = currentDate().getTime();

        // ## Assert ##
        assertNotNull(member);
        log(member.toString());
        assertEquals(memberId, member.memberId);
        log("cost: " + convertToPerformanceView(before, after));
    }

    // ===================================================================================
    //                                                                         Select List
    //                                                                         ===========
    public void test_selectList_prefixSearch_Tx() throws Exception {
        // ## Arrange ##
        final String prefix = "S";

        // ## Act ##
        final List<Member> memberList = jdbcManager.from(Member.class).where("memberName like ?", prefix + "%")
                .orderBy("birthdate desc, memberId asc").getResultList();

        // Assert ##
        assertNotNull(memberList);
        assertNotSame(0, memberList.size());
        for (Member member : memberList) {
            log(member.toString());
            assertTrue(member.memberName.startsWith(prefix));
        }
    }

    // ===================================================================================
    //                                                                           ManyToOne
    //                                                                           =========
    public void test_selectList_leftOuterJoin_fetch_ManyToOne_Tx() throws Exception {
        // ## Arrange ##
        // ## Act ##
        final List<Member> memberList = jdbcManager.from(Member.class).leftOuterJoin("memberStatus").getResultList();

        // Assert ##
        assertNotNull(memberList);
        assertNotSame(0, memberList.size());
        for (Member member : memberList) {
            log(member.memberName + " -- " + member.memberStatus);
            assertNotNull(member.memberStatus);
        }
    }

    // ===================================================================================
    //                                                                            OneToOne
    //                                                                            ========
    public void test_selectList_leftOuterJoin_fetch_OneToOne_Tx() throws Exception {
        // ## Arrange ##
        // ## Act ##
        final List<Member> memberList = jdbcManager.from(Member.class).leftOuterJoin("memberSecurity").getResultList();

        // Assert ##
        assertNotNull(memberList);
        assertNotSame(0, memberList.size());
        for (Member member : memberList) {
            log(member.memberName + " -- " + member.memberSecurity);
            assertNotNull(member.memberSecurity);
        }
    }

    // ===================================================================================
    //                                                                           OneToMany
    //                                                                           =========
    public void test_selectList_leftOuterJoin_fetch_OneToMany_Tx() throws Exception {
        // ## Arrange ##
        // ## Act ##
        long before = currentDate().getTime();
        final List<Member> memberList = jdbcManager.from(Member.class).leftOuterJoin("purchaseList").getResultList();
        long after = currentDate().getTime();

        // Assert ##
        assertNotNull(memberList);
        assertNotSame(0, memberList.size());
        boolean existsPurchase = false;
        for (Member member : memberList) {
            log(member.memberName);
            final List<Purchase> purchaseList = member.purchaseList;
            for (Purchase purchase : purchaseList) {
                assertNotNull(purchase);
                log("  " + purchase);
                existsPurchase = true;
                assertNull(purchase.product);
            }
        }
        assertTrue(existsPurchase);
        log("cost: " + convertToPerformanceView(before, after));
    }

    public void test_selectList_leftOuterJoin_fetch_OneToManyToOne_Tx() throws Exception {
        // ## Arrange ##
        // ## Act ##
        long before = currentDate().getTime();
        final List<Member> memberList = jdbcManager.from(Member.class).leftOuterJoin("purchaseList").leftOuterJoin(
                "purchaseList.product").getResultList();
        long after = currentDate().getTime();

        // ## Assert ##
        assertNotNull(memberList);
        assertNotSame(0, memberList.size());
        boolean existsPurchase = false;
        for (Member member : memberList) {
            log(member.memberName);
            final List<Purchase> purchaseList = member.purchaseList;
            for (Purchase purchase : purchaseList) {
                assertNotNull(purchase);
                log("  " + purchase.purchaseId + " -- " + purchase.product);
                assertNotNull(purchase.product);
                existsPurchase = true;
            }
        }
        assertTrue(existsPurchase);
        log("cost: " + convertToPerformanceView(before, after));
    }

    public void test_selectList_leftOuterJoin_fetch_OneToManyBranchTwo_Tx() throws Exception {
        // ## Arrange ##
        // ## Act ##
        long before = currentDate().getTime();
        final List<Member> memberList = jdbcManager.from(Member.class).leftOuterJoin("purchaseList").leftOuterJoin(
                "memberLoginList").getResultList();
        long after = currentDate().getTime();

        // ## Assert ##
        assertNotNull(memberList);
        assertNotSame(0, memberList.size());
        boolean existsPurchase = false;
        boolean existsLogin = false;
        for (Member member : memberList) {
            log(member.memberName);
            final List<Purchase> purchaseList = member.purchaseList;
            for (Purchase purchase : purchaseList) {
                assertNotNull(purchase);
                log("  " + purchase);
                existsPurchase = true;
                assertNull(purchase.product);
            }
            List<MemberLogin> memberLoginList = member.memberLoginList;
            for (MemberLogin login : memberLoginList) {
                assertNotNull(login);
                log("  " + login);
                existsLogin = true;
                assertNull(login.memberStatus);
            }
        }
        assertTrue(existsPurchase);
        assertTrue(existsLogin);
        log("cost: " + convertToPerformanceView(before, after));
    }

    public void test_selectList_leftOuterJoin_fetch_OneToManyBranchThree_Tx() throws Exception {
        // ## Arrange ##
        // ## Act ##
        long before = currentDate().getTime();
        final List<Member> memberList = jdbcManager.from(Member.class).leftOuterJoin("purchaseList").leftOuterJoin(
                "memberLoginList").leftOuterJoin("memberAddressList").getResultList();
        long after = currentDate().getTime();

        // ## Assert ##
        assertNotNull(memberList);
        assertNotSame(0, memberList.size());
        boolean existsPurchase = false;
        boolean existsLogin = false;
        boolean existsAddress = false;
        for (Member member : memberList) {
            log(member.memberName);
            final List<Purchase> purchaseList = member.purchaseList;
            for (Purchase purchase : purchaseList) {
                assertNotNull(purchase);
                log("  " + purchase);
                existsPurchase = true;
                assertNull(purchase.product);
            }
            List<MemberLogin> memberLoginList = member.memberLoginList;
            for (MemberLogin login : memberLoginList) {
                assertNotNull(login);
                log("  " + login);
                existsLogin = true;
                assertNull(login.memberStatus);
            }
            List<MemberAddress> memberAddressList = member.memberAddressList;
            for (MemberAddress address : memberAddressList) {
                assertNotNull(address);
                log("  " + address);
                existsAddress = true;
            }
        }
        assertTrue(existsPurchase);
        assertTrue(existsLogin);
        assertTrue(existsAddress);
        log("cost: " + convertToPerformanceView(before, after));
    }

    // ===================================================================================
    //                                                                       Type Handling
    //                                                                       =============
    public void test_Date_utilDateColumn_selects_sqlDate_Tx() throws Exception {
        // ## Arrange ##
        final Integer memberId = 1;

        // ## Act ##
        final Member member = jdbcManager.from(Member.class).where("memberId = ?", memberId).getSingleResult();

        // ## Assert ##
        assertNotNull(member);
        log(member.toString());
        assertEquals(memberId, member.memberId);
        assertEquals(java.sql.Date.class, member.birthdate.getClass());
    }

    // ===================================================================================
    //                                                                    Performance Cost
    //                                                                    ================
    public void test_performance_cost_Tx() throws Exception {
        // ## Arrange ##
        final String prefix = "S";

        // ## Act & Assert ##
        {
            long before = System.currentTimeMillis();
            List<Member> memberList = jdbcManager.from(Member.class).where("memberName like ?", prefix + "%").orderBy(
                    "birthdate desc, memberId asc").getResultList();
            long after = System.currentTimeMillis();
            log("1-[Performance Cost]: " + convertToPerformanceView(before, after) + " size=" + memberList.size());
        }
        {
            long before = System.currentTimeMillis();
            List<Member> memberList = jdbcManager.from(Member.class).where("memberName like ?", prefix + "%").orderBy(
                    "birthdate desc, memberId asc").getResultList();
            long after = System.currentTimeMillis();
            log("2-[Performance Cost]: " + convertToPerformanceView(before, after) + " size=" + memberList.size());
        }
        {
            long before = System.currentTimeMillis();
            List<Purchase> purchaseList = jdbcManager.from(Purchase.class).where("purchaseDatetime < ?", new Date())
                    .orderBy("purchaseId asc").getResultList();
            long after = System.currentTimeMillis();
            log("3-[Performance Cost]: " + convertToPerformanceView(before, after) + " size=" + purchaseList.size());
        }
    }

    protected String convertToPerformanceView(long before, long after) {
        return TraceViewUtil.convertToPerformanceView(after - before);
    }
}
