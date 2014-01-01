package com.example.dbflute.doma.dao;

import com.example.dbflute.doma.entity.Member;
import com.example.dbflute.doma.unit.ContainerTestCase;

/**
 * @author jflute
 * @since 0.9.6.1 (2009/11/23 Monday)
 */
public class SelectTest extends ContainerTestCase {

    private MemberDao memberDao;

    public void test_selectById() {
        // ## Arrange ##
        Integer memberId = 3;

        // ## Act ##
        Member member = memberDao.selectById(memberId);

        // ## Assert ##
        assertNotNull(member);
        log(member.toString());
        assertEquals(memberId, member.getMemberId());
    }
}
