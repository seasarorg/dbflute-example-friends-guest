package com.example.dbflute.doma.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import com.example.dbflute.doma.AppDomaConfig;
import com.example.dbflute.doma.entity.Member;

/**
 * @author jflute
 * @since 0.9.6.1 (2009/11/23 Monday)
 */
@Dao(config = AppDomaConfig.class)
public interface MemberDao {

    @Select
    Member selectById(Integer memberId);
}
