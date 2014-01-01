package com.example.dbflute.s2jdbc.various.whitebox;

import org.seasar.extension.sql.Node;
import org.seasar.extension.sql.SqlContext;
import org.seasar.extension.sql.SqlParser;
import org.seasar.extension.sql.context.SqlContextImpl;
import org.seasar.extension.sql.parser.SqlParserImpl;

import com.example.dbflute.s2jdbc.unit.PlainTestCase;

/**
 * @author jflute
 * @since 0.9.5 (2009/04/08)
 */
public class WxSqlParserTest extends PlainTestCase {

    // ===================================================================================
    //                                                                          IF comment
    //                                                                          ==========
    public void test_parse_IF_true() {
        // ## Arrange ##
        String sql = "/*IF pmb.memberName != null*/and member.MEMBER_NAME = 'TEST'/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName("foo");
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        assertEquals("and member.MEMBER_NAME = 'TEST'", ctx.getSql());
    }

    public void test_parse_IF_false() {
        // ## Arrange ##
        String sql = "/*IF pmb.memberName != null*/and member.MEMBER_NAME = 'TEST'/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName(null);
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        assertEquals("", ctx.getSql().trim());
    }

    // ===================================================================================
    //                                                                       BEGIN comment
    //                                                                       =============
    // -----------------------------------------------------
    //                                                 Basic
    //                                                 -----
    public void test_parse_BEGIN_for_where_all_true() {
        // ## Arrange ##
        String sql = "/*BEGIN*/where";
        sql = sql + " /*IF pmb.memberId != null*/member.MEMBER_ID = 3/*END*/";
        sql = sql + " /*IF pmb.memberName != null*/and member.MEMBER_NAME = 'TEST'/*END*/";
        sql = sql + "/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberId(3);
        pmb.setMemberName("foo");
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        String expected = "where member.MEMBER_ID = 3 and member.MEMBER_NAME = 'TEST'";
        assertEquals(expected, ctx.getSql());
    }

    public void test_parse_BEGIN_for_where_all_false() {
        // ## Arrange ##
        String sql = "/*BEGIN*/where";
        sql = sql + " /*IF pmb.memberId != null*/member.MEMBER_ID = 3/*END*/";
        sql = sql + " /*IF pmb.memberName != null*/and member.MEMBER_NAME = 'TEST'/*END*/";
        sql = sql + "/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        String expected = "";
        assertEquals(expected, ctx.getSql());
    }

    public void test_parse_BEGIN_for_select_all_true() {
        // ## Arrange ##
        String sql = "select /*BEGIN*/";
        sql = sql + "/*IF pmb.memberId != null*/member.MEMBER_ID as c1/*END*/";
        sql = sql + "/*IF pmb.memberName != null*/, member.MEMBER_NAME as c2/*END*/";
        sql = sql + "/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberId(3);
        pmb.setMemberName("foo");
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        String expected = "select member.MEMBER_ID as c1, member.MEMBER_NAME as c2";
        assertEquals(expected, ctx.getSql());
    }

    public void test_parse_BEGIN_for_select_all_false() {
        // ## Arrange ##
        String sql = "select /*BEGIN*/";
        sql = sql + "/*IF pmb.memberId != null*/member.MEMBER_ID as c1/*END*/";
        sql = sql + "/*IF pmb.memberName != null*/, member.MEMBER_NAME as c2/*END*/";
        sql = sql + "/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        String expected = "select ";
        assertEquals(expected, ctx.getSql());
    }

    // -----------------------------------------------------
    //                                                Nested
    //                                                ------
    public void test_parse_BEGIN_that_has_nested_IFIF_root_has_and() {
        // ## Arrange ##
        String sql = "/*BEGIN*/where";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberId != null*/";
        sql = sql + "FIXED";
        sql = sql + "/*END*/";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberName != null*/";
        sql = sql + "and AAA /*IF true*/and BBB /*IF true*/and CCC/*END*//*END*/ /*IF true*/and DDD/*END*/";
        sql = sql + "/*END*/";
        sql = sql + "/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName("foo");
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        //String expected = "where  AAA and BBB and CCC and DDD";
        String expected = "where  AAA BBB CCC and DDD";
        assertEquals(expected, ctx.getSql());
    }

    public void test_parse_BEGIN_that_has_nested_IFIF_root_has_no_and() {
        // ## Arrange ##
        String sql = "/*BEGIN*/where";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberName != null*/";
        sql = sql + "AAA /*IF true*/and BBB /*IF true*/and CCC/*END*//*END*/ /*IF true*/and DDD/*END*/";
        sql = sql + "/*END*/";
        sql = sql + "/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName("foo");
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        //String expected = "where AAA and BBB and CCC and DDD";
        String expected = "where AAA BBB CCC and DDD";
        assertEquals(expected, ctx.getSql());
    }

    public void test_parse_BEGIN_that_has_nested_IFIF_root_has_both() {
        // ## Arrange ##
        String sql = "/*BEGIN*/where";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberId != null*/";
        sql = sql + "FIXED";
        sql = sql + "/*END*/";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberName != null*/";
        sql = sql + "and AAA /*IF true*/and BBB /*IF true*/and CCC/*END*//*END*/ /*IF true*/and DDD/*END*/";
        sql = sql + "/*END*/";
        sql = sql + "/*END*/";
        sql = sql + " ";
        sql = sql + "/*BEGIN*/where";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberId != null*/";
        sql = sql + "FIXED";
        sql = sql + "/*END*/";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberName != null*/";
        sql = sql + "and AAA /*IF true*/and BBB /*IF true*/and CCC/*END*//*END*/ /*IF true*/and DDD/*END*/";
        sql = sql + "/*END*/";
        sql = sql + "/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName("foo");
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        //String expected = "where  AAA and BBB and CCC and DDD where  AAA and BBB and CCC and DDD";
        String expected = "where  AAA BBB CCC and DDD where  AAA BBB CCC and DDD";
        assertEquals(expected, ctx.getSql());
    }

    public void test_parse_BEGIN_that_has_nested_IFIF_fixed_condition_() {
        // ## Arrange ##
        String sql = "/*BEGIN*/where";
        sql = sql + " 1 = 1";
        sql = sql + "/*IF pmb.memberId != null*/";
        sql = sql + "and FIXED";
        sql = sql + "/*END*/";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberName != null*/";
        sql = sql + "and AAA /*IF true*/and BBB /*IF true*/and CCC/*END*//*END*/ /*IF true*/and DDD/*END*/";
        sql = sql + "/*END*/";
        sql = sql + "/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName("foo");
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        //String expected = "where 1 = 1 AAA and BBB and CCC and DDD";
        String expected = "where 1 = 1 AAA BBB CCC and DDD";
        assertEquals(expected, ctx.getSql());
    }

    public void test_parse_BEGIN_that_has_nested_IFIF_all_false() {
        // ## Arrange ##
        String sql = "/*BEGIN*/where";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberId != null*/";
        sql = sql + "AAA /*IF false*/and BBB /*IF false*/and CCC/*END*//*END*/ /*IF false*/and DDD/*END*/";
        sql = sql + "/*END*/";
        sql = sql + "/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        assertEquals("", ctx.getSql());
    }

    public void test_parse_BEGIN_that_has_nested_IFIF_formal_use_but_basically_nonsense() {
        // ## Arrange ##
        String sql = "/*BEGIN*/where";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberId != null*//*IF true*/and AAA/*END*//*END*/";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberName != null*/and BBB/*END*/";
        sql = sql + "/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberId(3);
        pmb.setMemberName("foo");
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        assertEquals("where AAA and BBB", ctx.getSql());
    }

    // -----------------------------------------------------
    //                                             UpperCase
    //                                             ---------
    public void test_parse_BEGIN_where_upperCase_that_has_nested_IFIF_root_has_and() {
        // ## Arrange ##
        String sql = "/*BEGIN*/WHERE";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberId != null*/";
        sql = sql + "FIXED";
        sql = sql + "/*END*/";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberName != null*/";
        sql = sql + "AND AAA /*IF true*/AND BBB /*IF true*/AND CCC/*END*//*END*/ /*IF true*/AND DDD/*END*/";
        sql = sql + "/*END*/";
        sql = sql + "/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName("foo");
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        //String expected = "WHERE  AAA AND BBB AND CCC AND DDD";
        String expected = "WHERE  AAA BBB CCC AND DDD";
        assertEquals(expected, ctx.getSql());
    }

    // -----------------------------------------------------
    //                                                    OR
    //                                                    --
    public void test_parse_BEGIN_where_upperCase_that_has_nested_IFIF_root_has_or() {
        // ## Arrange ##
        String sql = "/*BEGIN*/where";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberId != null*/";
        sql = sql + "FIXED";
        sql = sql + "/*END*/";
        sql = sql + " ";
        sql = sql + "/*IF pmb.memberName != null*/";
        sql = sql + "or AAA /*IF true*/and BBB /*IF true*/OR CCC/*END*//*END*/ /*IF true*/or DDD/*END*/";
        sql = sql + "/*END*/";
        sql = sql + "/*END*/";
        SqlParser analyzer = new SqlParserImpl(sql);

        // ## Act ##
        Node rootNode = analyzer.parse();

        // ## Assert ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName("foo");
        SqlContext ctx = createCtx(pmb);
        rootNode.accept(ctx);
        log("ctx:" + ctx);
        String expected = "where  AAA BBB CCC or DDD";
        assertEquals(expected, ctx.getSql());
    }

    // ===================================================================================
    //                                                                         Test Helper
    //                                                                         ===========
    protected static class SimpleMemberPmb {
        protected Integer memberId;
        protected String memberName;

        public Integer getMemberId() {
            return memberId;
        }

        public void setMemberId(Integer memberId) {
            this.memberId = memberId;
        }

        public String getMemberName() {
            return memberName;
        }

        public void setMemberName(String memberName) {
            this.memberName = memberName;
        }
    }

    private SqlContext createCtx(SimpleMemberPmb pmb) {
        return xcreateSqlContext(pmb, "pmb", pmb.getClass());
    }

    private SqlContext xcreateSqlContext(Object arg, String argName, Class<?> argType) {
        SqlContextImpl impl = new SqlContextImpl() {
            @Override
            public String toString() {
                return "{" + getSql() + "}";
            }
        };
        impl.addArg(argName, arg, argType);
        return impl;
    }
}
