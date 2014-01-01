package com.example.dbflute.hibernate.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.example.dbflute.hibernate.dbflute.allcommon.CDef;
import com.example.dbflute.hibernate.dbflute.exentity.Member;
import com.example.dbflute.hibernate.dbflute.exentity.MemberLogin;

/**
 * The entity of MEMBER_STATUS as TABLE. <br />
 * <pre>
 * [primary-key]
 *     MEMBER_STATUS_CODE
 * 
 * [column]
 *     MEMBER_STATUS_CODE, MEMBER_STATUS_NAME, DISPLAY_ORDER
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     
 * 
 * [version-no]
 *     
 * 
 * [foreign-table]
 *     
 * 
 * [referrer-table]
 *     MEMBER, MEMBER_LOGIN
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     memberList, memberLoginList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsMemberStatus implements com.example.dbflute.hibernate.dbflute.allcommon.Entity, Serializable {

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
    /** Property for memberStatusCode column. {PK, NotNull, CHAR(3), classification=MemberStatus} */
    @Id
    @Column(name="MEMBER_STATUS_CODE")
    protected String memberStatusCode;
    
    /** Property for memberStatusName column. {UQ, NotNull, VARCHAR(50)} */
    @Column(name="MEMBER_STATUS_NAME")
    protected String memberStatusName;
    
    /** Property for displayOrder column. {UQ, NotNull, INTEGER(10)} */
    @Column(name="DISPLAY_ORDER")
    protected Integer displayOrder;
    
    // ===================================================================================
    //                                                          Classification Classifying
    //                                                          ==========================
    /**
     * Classify the value of memberStatusCode as the classification of MemberStatus. <br />
     * 入会から退会までの会員のステータスを示す
     * @param cls The value of memberStatusCode as the classification of MemberStatus. (NullAllowed)
     */
    public void classifyMemberStatusCode(CDef.MemberStatus cls) {
        setMemberStatusCode(cls != null ? cls.code() : null);
    }

    /**
     * Classify the value of memberStatusCode as Provisional. <br />
     * 仮会員: 入会直後のステータスで一部のサイトサービスが利用可能
     */
    public void classifyMemberStatusCodeProvisional() {
        classifyMemberStatusCode(CDef.MemberStatus.Provisional);
    }

    /**
     * Classify the value of memberStatusCode as Formalized. <br />
     * 正式会員: 正式な会員としてサイトサービスが利用可能
     */
    public void classifyMemberStatusCodeFormalized() {
        classifyMemberStatusCode(CDef.MemberStatus.Formalized);
    }

    /**
     * Classify the value of memberStatusCode as Withdrawal. <br />
     * 退会会員: 退会が確定した会員でサイトサービスはダメ
     */
    public void classifyMemberStatusCodeWithdrawal() {
        classifyMemberStatusCode(CDef.MemberStatus.Withdrawal);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Get the value of memberStatusCode as the classification of MemberStatus. <br />
     * 入会から退会までの会員のステータスを示す
     * @return The value of memberStatusCode as the classification of MemberStatus. (NullAllowed)
     */
    public CDef.MemberStatus getMemberStatusCodeAsMemberStatus() {
        return CDef.MemberStatus.codeOf(memberStatusCode);
    }

    /**
     * Is the value of memberStatusCode 'Provisional'? <br />
     * 仮会員: 入会直後のステータスで一部のサイトサービスが利用可能
     * <p>
     * The difference of capital letters and small letters is NOT distinguished.
     * If the value is null, this method returns false!
     * </p>
     * @return The determination, true or false.
     */
    public boolean isMemberStatusCodeProvisional() {
        CDef.MemberStatus cls = getMemberStatusCodeAsMemberStatus();
        return cls != null ? cls.equals(CDef.MemberStatus.Provisional) : false;
    }

    /**
     * Is the value of memberStatusCode 'Formalized'? <br />
     * 正式会員: 正式な会員としてサイトサービスが利用可能
     * <p>
     * The difference of capital letters and small letters is NOT distinguished.
     * If the value is null, this method returns false!
     * </p>
     * @return The determination, true or false.
     */
    public boolean isMemberStatusCodeFormalized() {
        CDef.MemberStatus cls = getMemberStatusCodeAsMemberStatus();
        return cls != null ? cls.equals(CDef.MemberStatus.Formalized) : false;
    }

    /**
     * Is the value of memberStatusCode 'Withdrawal'? <br />
     * 退会会員: 退会が確定した会員でサイトサービスはダメ
     * <p>
     * The difference of capital letters and small letters is NOT distinguished.
     * If the value is null, this method returns false!
     * </p>
     * @return The determination, true or false.
     */
    public boolean isMemberStatusCodeWithdrawal() {
        CDef.MemberStatus cls = getMemberStatusCodeAsMemberStatus();
        return cls != null ? cls.equals(CDef.MemberStatus.Withdrawal) : false;
    }

    // ===================================================================================
    //                                                           Classification Name/Alias
    //                                                           =========================
    /**
     * Get the value of the column 'memberStatusCode' as classification name.
     * @return The value of the column 'memberStatusCode' as classification name. (NullAllowed)
     */
    public String getMemberStatusCodeName() {
        CDef.MemberStatus cls = getMemberStatusCodeAsMemberStatus();
        return cls != null ? cls.name() : null;
    }

    /**
     * Get the value of the column 'memberStatusCode' as classification alias.
     * @return The value of the column 'memberStatusCode' as classification alias. (NullAllowed)
     */
    public String getMemberStatusCodeAlias() {
        CDef.MemberStatus cls = getMemberStatusCodeAsMemberStatus();
        return cls != null ? cls.alias() : null;
    }

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    /** MEMBER by MEMBER_STATUS_CODE, named 'memberList'. */
    @OneToMany(mappedBy = "memberStatus", fetch=FetchType.LAZY)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    protected List<Member> memberList;

    /**
     * MEMBER by MEMBER_STATUS_CODE, named 'memberList'.
     * @return The entity list of referrer property 'memberList'. (NotNull: If it's not loaded yet, initializes the list instance of referrer as empty and returns it.)
     */
    public List<Member> getMemberList() {
        return memberList;
    }

    /**
     * MEMBER by MEMBER_STATUS_CODE, named 'memberList'.
     * @param memberList The entity list of referrer property 'memberList'. (NullAllowed)
     */
    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    /** MEMBER_LOGIN by LOGIN_MEMBER_STATUS_CODE, named 'memberLoginList'. */
    @OneToMany(mappedBy = "memberStatus", fetch=FetchType.LAZY)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    protected List<MemberLogin> memberLoginList;

    /**
     * MEMBER_LOGIN by LOGIN_MEMBER_STATUS_CODE, named 'memberLoginList'.
     * @return The entity list of referrer property 'memberLoginList'. (NotNull: If it's not loaded yet, initializes the list instance of referrer as empty and returns it.)
     */
    public List<MemberLogin> getMemberLoginList() {
        return memberLoginList;
    }

    /**
     * MEMBER_LOGIN by LOGIN_MEMBER_STATUS_CODE, named 'memberLoginList'.
     * @param memberLoginList The entity list of referrer property 'memberLoginList'. (NullAllowed)
     */
    public void setMemberLoginList(List<MemberLogin> memberLoginList) {
        this.memberLoginList = memberLoginList;
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * If the primary-key of the other is same as this one, returns true.
     * @param other Other entity.
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsMemberStatus)) { return false; }
        BsMemberStatus otherEntity = (BsMemberStatus)other;
        if (!helpComparingValue(getMemberStatusCode(), otherEntity.getMemberStatusCode())) { return false; }
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
        if (getMemberStatusCode() != null) { result = (31*result) + getMemberStatusCode().hashCode(); }
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
        if (memberList != null)
        { for (com.example.dbflute.hibernate.dbflute.allcommon.Entity e : memberList)
        { if (e != null) { sb.append(l).append(xbRDS(e, "memberList")); } } }
        if (memberLoginList != null)
        { for (com.example.dbflute.hibernate.dbflute.allcommon.Entity e : memberLoginList)
        { if (e != null) { sb.append(l).append(xbRDS(e, "memberLoginList")); } } }
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
        sb.append(c).append(memberStatusCode);
        sb.append(c).append(memberStatusName);
        sb.append(c).append(displayOrder);
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    private String xbuildRelationString() {
        StringBuilder sb = new StringBuilder();
        String c = ",";
        if (memberList != null && !memberList.isEmpty())
        { sb.append(c).append("memberList"); }
        if (memberLoginList != null && !memberLoginList.isEmpty())
        { sb.append(c).append("memberLoginList"); }
        if (sb.length() > 0) { sb.delete(0, c.length()).insert(0, "(").append(")"); }
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus} <br />
     * @return The value of the column 'MEMBER_STATUS_CODE'. (NullAllowed)
     */
    public String getMemberStatusCode() {
        return memberStatusCode;
    }

    /**
     * MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus} <br />
     * @param memberStatusCode The value of the column 'MEMBER_STATUS_CODE'. (NullAllowed)
     */
    public void setMemberStatusCode(String memberStatusCode) {
        this.memberStatusCode = memberStatusCode;
    }

    /**
     * MEMBER_STATUS_NAME: {UQ, NotNull, VARCHAR(50)} <br />
     * @return The value of the column 'MEMBER_STATUS_NAME'. (NullAllowed)
     */
    public String getMemberStatusName() {
        return memberStatusName;
    }

    /**
     * MEMBER_STATUS_NAME: {UQ, NotNull, VARCHAR(50)} <br />
     * @param memberStatusName The value of the column 'MEMBER_STATUS_NAME'. (NullAllowed)
     */
    public void setMemberStatusName(String memberStatusName) {
        this.memberStatusName = memberStatusName;
    }

    /**
     * DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)} <br />
     * @return The value of the column 'DISPLAY_ORDER'. (NullAllowed)
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)} <br />
     * @param displayOrder The value of the column 'DISPLAY_ORDER'. (NullAllowed)
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}
