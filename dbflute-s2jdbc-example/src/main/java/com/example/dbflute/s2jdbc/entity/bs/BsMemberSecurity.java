package com.example.dbflute.s2jdbc.entity.bs;

import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.s2jdbc.entity.*;

/**
 * The entity of (会員セキュリティ情報)MEMBER_SECURITY as TABLE. <br />
 * 会員とは one-to-one で、会員一人につき必ず一つのセキュリティ情報がある
 * <pre>
 * [primary-key]
 *     MEMBER_ID
 * 
 * [column]
 *     MEMBER_ID, LOGIN_PASSWORD, REMINDER_QUESTION, REMINDER_ANSWER, REMINDER_USE_COUNT, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsMemberSecurity implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * (会員ID)MEMBER_ID: {PK, NotNull, INTEGER(10), FK to MEMBER} <br />
     * そのまま one-to-one を構成するためのFKとなる。
     */
    @Id
    public Integer memberId;

    /**
     * (ログインパスワード)LOGIN_PASSWORD: {NotNull, VARCHAR(50)} <br />
     * ログイン時に利用するパスワード。<br />
     * 本当は良くないが、Exampleなのでひとまず暗号化していない。
     */
    public String loginPassword;

    /**
     * (リマインダ質問)REMINDER_QUESTION: {NotNull, VARCHAR(50)} <br />
     * パスワードを忘れた際のリマインダ機能における質問の内容。
     */
    public String reminderQuestion;

    /**
     * (リマインダ回答)REMINDER_ANSWER: {NotNull, VARCHAR(50)} <br />
     * パスワードを忘れた際のリマインダ機能における質問の答え。
     */
    public String reminderAnswer;

    /**
     * (リマインダ利用回数)REMINDER_USE_COUNT: {NotNull, INTEGER(10)} <br />
     * リマインダを利用した回数。<br />
     * 多いと忘れっぽい会員と言えるが、<br />
     * そんなことを知ってもしょうがない。
     */
    public Integer reminderUseCount;

    /**
     * REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.sql.Timestamp registerDatetime;

    /**
     * REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     */
    public String registerUser;

    /**
     * UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.sql.Timestamp updateDatetime;

    /**
     * UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     */
    public String updateUser;

    /**
     * VERSION_NO: {NotNull, BIGINT(19)} <br />
     */
    @Version
    public Long versionNo;

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    /**
     * (会員)MEMBER by my MEMBER_ID, named 'member'.
     */
    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    public Member member;

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * If the primary-key of the other is same as this one, returns true.
     * @param other Other entity.
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsMemberSecurity)) { return false; }
        BsMemberSecurity otherEntity = (BsMemberSecurity)other;
        if (!helpComparingValue(memberId, otherEntity.memberId)) { return false; }
        return true;
    }

    protected boolean helpComparingValue(Object value1, Object value2) {
        if (value1 == null && value2 == null) { return true; }
        return value1 != null && value2 != null && value1.equals(value2);
    }

    /**
     * Calculates hash-code from primary-key.
     * @return Hash-code from primary-key.
     */
    public int hashCode() {
        int result = 17;
        if (memberId != null) { result = (31*result) + memberId.hashCode(); }
        return result;
    }

    /**
     * @return The view string of all columns. (NotNull)
     */
    public String toString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(memberId);
        sb.append(delimiter).append(loginPassword);
        sb.append(delimiter).append(reminderQuestion);
        sb.append(delimiter).append(reminderAnswer);
        sb.append(delimiter).append(reminderUseCount);
        sb.append(delimiter).append(registerDatetime);
        sb.append(delimiter).append(registerUser);
        sb.append(delimiter).append(updateDatetime);
        sb.append(delimiter).append(updateUser);
        sb.append(delimiter).append(versionNo);
        if (sb.length() > 0) { sb.delete(0, delimiter.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
