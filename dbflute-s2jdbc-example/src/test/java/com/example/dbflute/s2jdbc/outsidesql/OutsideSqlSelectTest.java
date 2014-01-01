package com.example.dbflute.s2jdbc.outsidesql;

import java.util.List;

import org.seasar.extension.jdbc.JdbcManager;

import com.example.dbflute.s2jdbc.entity.customize.SimpleMember;
import com.example.dbflute.s2jdbc.entity.pmbean.SimpleMemberPmb;
import com.example.dbflute.s2jdbc.unit.ContainerTestCase;

/**
 * @author jflute
 * @since 0.6.9 (2008/04/11)
 */
public class OutsideSqlSelectTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    public JdbcManager jdbcManager;

    // ===================================================================================
    //                                                                     selectBySqlFile
    //                                                                     ===============
    public void test_selectBySqlFile_getResultList_Tx() throws Exception {
        // ## Arrange ##
        final String prefix = "S";
        final SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.memberName = prefix;

        // ## Act ##
        final List<SimpleMember> memberList = jdbcManager.selectBySqlFile(SimpleMember.class,
                "sql/member/selectSimpleMember.sql", pmb).getResultList();

        // ## Assert ##
        assertNotNull(memberList);
        assertNotSame(0, memberList);
        for (SimpleMember member : memberList) {
            log(member.toString());
            assertTrue(member.memberName.startsWith(prefix));
        }
    }
}
