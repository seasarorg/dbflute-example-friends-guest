package com.example.dbflute.doma;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.example.dbflute.doma.dao.MemberDao;
import com.example.dbflute.doma.dao.MemberDaoImpl;

/**
 * @author jflute
 * @since 0.9.6.1 (2009/11/23 Monday)
 */
public class AppDomaModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(MemberDao.class).toInstance(new MemberDaoImpl());
    }
}