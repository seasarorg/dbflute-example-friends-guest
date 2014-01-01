package com.example.dbflute.doma;

import java.io.File;
import java.io.IOException;

import org.seasar.dbflute.util.DfReflectionUtil;
import org.seasar.dbflute.util.DfResourceUtil;

/**
 * 単にH2データベースへのパスを解決するためのクラス。<br />
 * Doma Exampleとしての本質的なクラスではないので、特に気にする必要はない。
 * @author jflute
 * @since 0.9.6.1 (2009/11/23 Monday)
 */
public class EmbeddedH2UrlFactoryBean {

    private String urlSuffix;
    private String referenceClassName;

    public Object getObject() throws Exception {
        return getUrl();
    }

    public Class<?> getObjectType() {
        return String.class;
    }

    public boolean isSingleton() {
        return true;
    }

    private String getUrl() {
        try {
            final File f = getBuildDir();
            final String canonicalPath = f.getCanonicalPath();
            final String url = "jdbc:h2:file:" + canonicalPath.replace('\\', '/') + urlSuffix;
            return url;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File getBuildDir() {
        final Class<?> clazz = DfReflectionUtil.forName(referenceClassName);
        return DfResourceUtil.getBuildDir(clazz);
    }

    public void setReferenceClassName(final String referenceClassName) {
        this.referenceClassName = referenceClassName;
    }

    public void setUrlSuffix(final String urlSuffix) {
        this.urlSuffix = urlSuffix;
    }
}
