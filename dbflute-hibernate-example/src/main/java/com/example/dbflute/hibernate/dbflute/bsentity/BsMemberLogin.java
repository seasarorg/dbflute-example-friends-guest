package com.example.dbflute.hibernate.dbflute.bsentity;

import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.hibernate.dbflute.allcommon.CDef;
import com.example.dbflute.hibernate.dbflute.exentity.Member;
import com.example.dbflute.hibernate.dbflute.exentity.MemberStatus;

/**
 * The entity of MEMBER_LOGIN as TABLE. <br />
 * <pre>
 * [primary-key]
 *     MEMBER_LOGIN_ID
 * 
 * [column]
 *     MEMBER_LOGIN_ID, MEMBER_ID, LOGIN_DATETIME, MOBILE_LOGIN_FLG, LOGIN_MEMBER_STATUS_CODE
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_LOGIN_ID
 * 
 * [version-no]
 *     
 * 
 * [foreign-table]
 *     MEMBER, MEMBER_STATUS
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, memberStatus
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsMemberLogin implements com.example.dbflute.hibernate.dbflute.allcommon.Entity, Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** Property for memberLoginId column. {PK, ID, NotNull, BIGINT(19)} */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEMBER_LOGIN_ID")
    protected Long memberLoginId;
    
    /** Property for loginDatetime column. {UQ+, NotNull, TIMESTAMP(23, 10)} */
    @Column(name="LOGIN_DATETIME")
    protected java.sql.Timestamp loginDatetime;
    
    /** Property for mobileLoginFlg column. {NotNull, INTEGER(10), classification=Flg} */
    @Column(name="MOBILE_LOGIN_FLG")
    protected Integer mobileLoginFlg;
    
    // ===================================================================================
    //                                                          Classification Classifying
    //                                                          ==========================
    /**
     * Classify the value of mobileLoginFlg as the classification of Flg. <br />
     * フラグを示す
     * @param cls The value of mobileLoginFlg as the classification of Flg. (NullAllowed)
     */
    public void classifyMobileLoginFlg(CDef.Flg cls) {
        setMobileLoginFlg(cls != null ? Integer.valueOf(cls.code()) : null);
    }

    /**
     * Classify the value of mobileLoginFlg as True. <br />
     * はい: 有効を示す
     */
    public void classifyMobileLoginFlgTrue() {
        classifyMobileLoginFlg(CDef.Flg.True);
    }

    /**
     * Classify the value of mobileLoginFlg as False. <br />
     * いいえ: 無効を示す
     */
    public void classifyMobileLoginFlgFalse() {
        classifyMobileLoginFlg(CDef.Flg.False);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Get the value of mobileLoginFlg as the classification of Flg. <br />
     * フラグを示す
     * @return The value of mobileLoginFlg as the classification of Flg. (NullAllowed)
     */
    public CDef.Flg getMobileLoginFlgAsFlg() {
        return CDef.Flg.codeOf(mobileLoginFlg);
    }

    /**
     * Is the value of mobileLoginFlg 'True'? <br />
     * はい: 有効を示す
     * <p>
     * The difference of capital letters and small letters is NOT distinguished.
     * If the value is null, this method returns false!
     * </p>
     * @return The determination, true or false.
     */
    public boolean isMobileLoginFlgTrue() {
        CDef.Flg cls = getMobileLoginFlgAsFlg();
        return cls != null ? cls.equals(CDef.Flg.True) : false;
    }

    /**
     * Is the value of mobileLoginFlg 'False'? <br />
     * いいえ: 無効を示す
     * <p>
     * The difference of capital letters and small letters is NOT distinguished.
     * If the value is null, this method returns false!
     * </p>
     * @return The determination, true or false.
     */
    public boolean isMobileLoginFlgFalse() {
        CDef.Flg cls = getMobileLoginFlgAsFlg();
        return cls != null ? cls.equals(CDef.Flg.False) : false;
    }

    // ===================================================================================
    //                                                           Classification Name/Alias
    //                                                           =========================
    /**
     * Get the value of the column 'mobileLoginFlg' as classification name.
     * @return The value of the column 'mobileLoginFlg' as classification name. (NullAllowed)
     */
    public String getMobileLoginFlgName() {
        CDef.Flg cls = getMobileLoginFlgAsFlg();
        return cls != null ? cls.name() : null;
    }

    /**
     * Get the value of the column 'mobileLoginFlg' as classification alias.
     * @return The value of the column 'mobileLoginFlg' as classification alias. (NullAllowed)
     */
    public String getMobileLoginFlgAlias() {
        CDef.Flg cls = getMobileLoginFlgAsFlg();
        return cls != null ? cls.alias() : null;
    }

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    /** MEMBER by my MEMBER_ID, named 'member'. */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    protected Member member;

    /**
     * MEMBER by my MEMBER_ID, named 'member'.
     * @return The entity of foreign property 'member'. (NullAllowed: If the foreign key does not have 'NotNull' constraint, please check null.)
     */
    public Member getMember() {
        return member;
    }

    /**
     * MEMBER by my MEMBER_ID, named 'member'.
     * @param member The entity of foreign property 'member'. (NullAllowed)
     */
    public void setMember(Member member) {
        this.member = member;
    }

    /** MEMBER_STATUS by my LOGIN_MEMBER_STATUS_CODE, named 'memberStatus'. */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LOGIN_MEMBER_STATUS_CODE")
    protected MemberStatus memberStatus;

    /**
     * MEMBER_STATUS by my LOGIN_MEMBER_STATUS_CODE, named 'memberStatus'.
     * @return The entity of foreign property 'memberStatus'. (NullAllowed: If the foreign key does not have 'NotNull' constraint, please check null.)
     */
    public MemberStatus getMemberStatus() {
        return memberStatus;
    }

    /**
     * MEMBER_STATUS by my LOGIN_MEMBER_STATUS_CODE, named 'memberStatus'.
     * @param memberStatus The entity of foreign property 'memberStatus'. (NullAllowed)
     */
    public void setMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }

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
        if (other == null || !(other instanceof BsMemberLogin)) { return false; }
        BsMemberLogin otherEntity = (BsMemberLogin)other;
        if (!helpComparingValue(getMemberLoginId(), otherEntity.getMemberLoginId())) { return false; }
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
        if (getMemberLoginId() != null) { result = (31*result) + getMemberLoginId().hashCode(); }
        return result;
    }

    /**
     * @return The display string of all columns. (NotNull)
     */
    public String toString() {
        return buildDisplayString(getClass().getSimpleName(), true, false);
    }

    /**
     * @return The display string of basic informations with one-nested relation values. (NotNull)
     */
    public String toStringWithRelation() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        String l = "\n  ";
        if (member != null)
        { sb.append(l).append(xbRDS(member, "member")); }
        if (memberStatus != null)
        { sb.append(l).append(xbRDS(memberStatus, "memberStatus")); }
        return sb.toString();
    }
    private String xbRDS(com.example.dbflute.hibernate.dbflute.allcommon.Entity e, String name) { // buildRelationDisplayString()
        return e.buildDisplayString(name, true, true);
    }

    /**
     * @param name The name for display. (NullAllowed: If it's null, it does not have a name)
     * @param column Does it contains column values or not?
     * @param relation Does it contains relation existences or not?
     * @return The display string for this entity. (NotNull)
     */
    public String buildDisplayString(String name, boolean column, boolean relation) {
        StringBuilder sb = new StringBuilder();
        if (name != null) { sb.append(name).append(column || relation ? ":" : ""); }
        if (column) { sb.append(xbuildColumnString()); }
        if (relation) { sb.append(xbuildRelationString()); }
        sb.append("@").append(Integer.toHexString(hashCode()));
        return sb.toString();
    }
    private String xbuildColumnString() {
        String c = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(c).append(memberLoginId);
        sb.append(c).append(loginDatetime);
        sb.append(c).append(mobileLoginFlg);
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    private String xbuildRelationString() {
        StringBuilder sb = new StringBuilder();
        String c = ",";
        if (member != null) { sb.append(c).append("member"); }
        if (memberStatus != null) { sb.append(c).append("memberStatus"); }
        if (sb.length() > 0) { sb.delete(0, c.length()).insert(0, "(").append(")"); }
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * MEMBER_LOGIN_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * @return The value of the column 'MEMBER_LOGIN_ID'. (NullAllowed)
     */
    public Long getMemberLoginId() {
        return memberLoginId;
    }

    /**
     * MEMBER_LOGIN_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * @param memberLoginId The value of the column 'MEMBER_LOGIN_ID'. (NullAllowed)
     */
    public void setMemberLoginId(Long memberLoginId) {
        this.memberLoginId = memberLoginId;
    }

    /**
     * LOGIN_DATETIME: {UQ+, NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'LOGIN_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getLoginDatetime() {
        return loginDatetime;
    }

    /**
     * LOGIN_DATETIME: {UQ+, NotNull, TIMESTAMP(23, 10)} <br />
     * @param loginDatetime The value of the column 'LOGIN_DATETIME'. (NullAllowed)
     */
    public void setLoginDatetime(java.sql.Timestamp loginDatetime) {
        this.loginDatetime = loginDatetime;
    }

    /**
     * MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * @return The value of the column 'MOBILE_LOGIN_FLG'. (NullAllowed)
     */
    public Integer getMobileLoginFlg() {
        return mobileLoginFlg;
    }

    /**
     * MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * @param mobileLoginFlg The value of the column 'MOBILE_LOGIN_FLG'. (NullAllowed)
     */
    public void setMobileLoginFlg(Integer mobileLoginFlg) {
        this.mobileLoginFlg = mobileLoginFlg;
    }
}
