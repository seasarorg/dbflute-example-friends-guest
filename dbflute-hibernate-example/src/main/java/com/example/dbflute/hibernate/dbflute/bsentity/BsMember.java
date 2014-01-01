package com.example.dbflute.hibernate.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.example.dbflute.hibernate.dbflute.allcommon.CommonColumnAutoSetupper;
import com.example.dbflute.hibernate.dbflute.allcommon.EntityDefinedCommonColumn;
import com.example.dbflute.hibernate.dbflute.allcommon.CDef;
import com.example.dbflute.hibernate.dbflute.exentity.MemberStatus;
import com.example.dbflute.hibernate.dbflute.exentity.MemberLogin;
import com.example.dbflute.hibernate.dbflute.exentity.MemberSecurity;
import com.example.dbflute.hibernate.dbflute.exentity.MemberWithdrawal;
import com.example.dbflute.hibernate.dbflute.exentity.Purchase;

/**
 * The entity of MEMBER as TABLE. <br />
 * <pre>
 * [primary-key]
 *     MEMBER_ID
 * 
 * [column]
 *     MEMBER_ID, MEMBER_NAME, MEMBER_ACCOUNT, MEMBER_STATUS_CODE, FORMALIZED_DATETIME, BIRTHDATE, REGISTER_DATETIME, REGISTER_USER, REGISTER_PROCESS, UPDATE_DATETIME, UPDATE_USER, UPDATE_PROCESS, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER_STATUS, MEMBER_SECURITY(AsOne), MEMBER_WITHDRAWAL(AsOne)
 * 
 * [referrer-table]
 *     MEMBER_LOGIN, PURCHASE, MEMBER_SECURITY, MEMBER_WITHDRAWAL
 * 
 * [foreign-property]
 *     memberStatus, memberSecurityAsOne, memberWithdrawalAsOne
 * 
 * [referrer-property]
 *     memberLoginList, purchaseList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsMember implements EntityDefinedCommonColumn, Serializable {

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
    /** Property for memberId column. {PK, ID, NotNull, INTEGER(10)} */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEMBER_ID")
    protected Integer memberId;
    
    /** Property for memberName column. {NotNull, VARCHAR(200)} */
    @Column(name="MEMBER_NAME")
    protected String memberName;
    
    /** Property for memberAccount column. {UQ, NotNull, VARCHAR(50)} */
    @Column(name="MEMBER_ACCOUNT")
    protected String memberAccount;
    
    /** Property for formalizedDatetime column. {TIMESTAMP(23, 10)} */
    @Column(name="FORMALIZED_DATETIME")
    protected java.sql.Timestamp formalizedDatetime;
    
    /** Property for birthdate column. {DATE(8)} */
    @Column(name="BIRTHDATE")
    protected java.util.Date birthdate;
    
    /** Property for registerDatetime column. {NotNull, TIMESTAMP(23, 10)} */
    @Column(name="REGISTER_DATETIME")
    protected java.sql.Timestamp registerDatetime;
    
    /** Property for registerUser column. {NotNull, VARCHAR(200)} */
    @Column(name="REGISTER_USER")
    protected String registerUser;
    
    /** Property for registerProcess column. {NotNull, VARCHAR(200)} */
    @Column(name="REGISTER_PROCESS")
    protected String registerProcess;
    
    /** Property for updateDatetime column. {NotNull, TIMESTAMP(23, 10)} */
    @Column(name="UPDATE_DATETIME")
    protected java.sql.Timestamp updateDatetime;
    
    /** Property for updateUser column. {NotNull, VARCHAR(200)} */
    @Column(name="UPDATE_USER")
    protected String updateUser;
    
    /** Property for updateProcess column. {NotNull, VARCHAR(200)} */
    @Column(name="UPDATE_PROCESS")
    protected String updateProcess;
    
    /** Property for versionNo column. {NotNull, BIGINT(19)} */
    @Version
    @Column(name="VERSION_NO")
    protected Long versionNo;
    
    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** Is common column auto set up effective? */
    @Transient
    protected boolean _canCommonColumnAutoSetup = true;

    // ===================================================================================
    //                                                          Classification Classifying
    //                                                          ==========================
    /**
     * Classify the value of memberStatusCode as the classification of MemberStatus. <br />
     * 入会から退会までの会員のステータスを示す
     * @param cls The value of memberStatusCode as the classification of MemberStatus. (NullAllowed)
     */
    public void classifyMemberStatusCode(CDef.MemberStatus cls) {
        final MemberStatus entity = new MemberStatus();
        entity.setMemberStatusCode(cls.code());
        setMemberStatus(entity);
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
        return CDef.MemberStatus.codeOf(getMemberStatus().getMemberStatusCode());
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
    /** MEMBER_STATUS by my MEMBER_STATUS_CODE, named 'memberStatus'. */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MEMBER_STATUS_CODE")
    protected MemberStatus memberStatus;

    /**
     * MEMBER_STATUS by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @return The entity of foreign property 'memberStatus'. (NullAllowed: If the foreign key does not have 'NotNull' constraint, please check null.)
     */
    public MemberStatus getMemberStatus() {
        return memberStatus;
    }

    /**
     * MEMBER_STATUS by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @param memberStatus The entity of foreign property 'memberStatus'. (NullAllowed)
     */
    public void setMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }

    /** MEMBER_SECURITY by MEMBER_ID, named 'memberSecurityAsOne'. */
    @OneToOne(mappedBy = "member", fetch=FetchType.LAZY)
    protected MemberSecurity memberSecurityAsOne;

    /**
     * MEMBER_SECURITY by MEMBER_ID, named 'memberSecurityAsOne'.
     * @return the entity of foreign property(referrer-as-one) 'memberSecurityAsOne'. (NullAllowed: If the foreign key does not have 'NotNull' constraint, please check null.)
     */
    public MemberSecurity getMemberSecurityAsOne() {
        return memberSecurityAsOne;
    }

    /**
     * MEMBER_SECURITY by MEMBER_ID, named 'memberSecurityAsOne'.
     * @param memberSecurityAsOne The entity of foreign property(referrer-as-one) 'memberSecurityAsOne'. (NullAllowed)
     */
    public void setMemberSecurityAsOne(MemberSecurity memberSecurityAsOne) {
        this.memberSecurityAsOne = memberSecurityAsOne;
    }

    /** MEMBER_WITHDRAWAL by MEMBER_ID, named 'memberWithdrawalAsOne'. */
    @OneToOne(mappedBy = "member", fetch=FetchType.LAZY)
    protected MemberWithdrawal memberWithdrawalAsOne;

    /**
     * MEMBER_WITHDRAWAL by MEMBER_ID, named 'memberWithdrawalAsOne'.
     * @return the entity of foreign property(referrer-as-one) 'memberWithdrawalAsOne'. (NullAllowed: If the foreign key does not have 'NotNull' constraint, please check null.)
     */
    public MemberWithdrawal getMemberWithdrawalAsOne() {
        return memberWithdrawalAsOne;
    }

    /**
     * MEMBER_WITHDRAWAL by MEMBER_ID, named 'memberWithdrawalAsOne'.
     * @param memberWithdrawalAsOne The entity of foreign property(referrer-as-one) 'memberWithdrawalAsOne'. (NullAllowed)
     */
    public void setMemberWithdrawalAsOne(MemberWithdrawal memberWithdrawalAsOne) {
        this.memberWithdrawalAsOne = memberWithdrawalAsOne;
    }

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    /** MEMBER_LOGIN by MEMBER_ID, named 'memberLoginList'. */
    @OneToMany(mappedBy = "member", fetch=FetchType.LAZY)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    protected List<MemberLogin> memberLoginList;

    /**
     * MEMBER_LOGIN by MEMBER_ID, named 'memberLoginList'.
     * @return The entity list of referrer property 'memberLoginList'. (NotNull: If it's not loaded yet, initializes the list instance of referrer as empty and returns it.)
     */
    public List<MemberLogin> getMemberLoginList() {
        return memberLoginList;
    }

    /**
     * MEMBER_LOGIN by MEMBER_ID, named 'memberLoginList'.
     * @param memberLoginList The entity list of referrer property 'memberLoginList'. (NullAllowed)
     */
    public void setMemberLoginList(List<MemberLogin> memberLoginList) {
        this.memberLoginList = memberLoginList;
    }

    /** PURCHASE by MEMBER_ID, named 'purchaseList'. */
    @OneToMany(mappedBy = "member", fetch=FetchType.LAZY)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    protected List<Purchase> purchaseList;

    /**
     * PURCHASE by MEMBER_ID, named 'purchaseList'.
     * @return The entity list of referrer property 'purchaseList'. (NotNull: If it's not loaded yet, initializes the list instance of referrer as empty and returns it.)
     */
    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    /**
     * PURCHASE by MEMBER_ID, named 'purchaseList'.
     * @param purchaseList The entity list of referrer property 'purchaseList'. (NullAllowed)
     */
    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    // ===================================================================================
    //                                                              Common Column Handling
    //                                                              ======================
    @PrePersist
    public void doPrePersist() {
        CommonColumnAutoSetupper setupper = createCommonColumnAutoSetupper();
        setupper.handleCommonColumnOfInsertIfNeeds(this);
    }

    @PreUpdate
    public void doPreUpdate() {
        CommonColumnAutoSetupper setupper = createCommonColumnAutoSetupper();
        setupper.handleCommonColumnOfUpdateIfNeeds(this);
    }

    protected CommonColumnAutoSetupper createCommonColumnAutoSetupper() {
        return new CommonColumnAutoSetupper();
    }

    /**
     * Enable common column auto set up. {for after disable because the default is enabled}
     */
    public void enableCommonColumnAutoSetup() {
        _canCommonColumnAutoSetup = true;
    }

    /**
     * Disables auto set-up of common columns.
     */
    public void disableCommonColumnAutoSetup() {
        _canCommonColumnAutoSetup = false;
    }
    
    /**
     * Can the entity set up common column by auto?
     * @return The determination, true or false.
     */
    public boolean canCommonColumnAutoSetup() { // for Framework
        return _canCommonColumnAutoSetup;
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
        if (other == null || !(other instanceof BsMember)) { return false; }
        BsMember otherEntity = (BsMember)other;
        if (!helpComparingValue(getMemberId(), otherEntity.getMemberId())) { return false; }
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
        if (getMemberId() != null) { result = (31*result) + getMemberId().hashCode(); }
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
        if (memberStatus != null)
        { sb.append(l).append(xbRDS(memberStatus, "memberStatus")); }
        if (memberSecurityAsOne != null)
        { sb.append(l).append(xbRDS(memberSecurityAsOne, "memberSecurityAsOne")); }
        if (memberWithdrawalAsOne != null)
        { sb.append(l).append(xbRDS(memberWithdrawalAsOne, "memberWithdrawalAsOne")); }
        if (memberLoginList != null)
        { for (com.example.dbflute.hibernate.dbflute.allcommon.Entity e : memberLoginList)
        { if (e != null) { sb.append(l).append(xbRDS(e, "memberLoginList")); } } }
        if (purchaseList != null)
        { for (com.example.dbflute.hibernate.dbflute.allcommon.Entity e : purchaseList)
        { if (e != null) { sb.append(l).append(xbRDS(e, "purchaseList")); } } }
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
        sb.append(c).append(memberId);
        sb.append(c).append(memberName);
        sb.append(c).append(memberAccount);
        sb.append(c).append(formalizedDatetime);
        sb.append(c).append(birthdate);
        sb.append(c).append(registerDatetime);
        sb.append(c).append(registerUser);
        sb.append(c).append(registerProcess);
        sb.append(c).append(updateDatetime);
        sb.append(c).append(updateUser);
        sb.append(c).append(updateProcess);
        sb.append(c).append(versionNo);
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    private String xbuildRelationString() {
        StringBuilder sb = new StringBuilder();
        String c = ",";
        if (memberStatus != null) { sb.append(c).append("memberStatus"); }
        if (memberSecurityAsOne != null) { sb.append(c).append("memberSecurityAsOne"); }
        if (memberWithdrawalAsOne != null) { sb.append(c).append("memberWithdrawalAsOne"); }
        if (memberLoginList != null && !memberLoginList.isEmpty())
        { sb.append(c).append("memberLoginList"); }
        if (purchaseList != null && !purchaseList.isEmpty())
        { sb.append(c).append("purchaseList"); }
        if (sb.length() > 0) { sb.delete(0, c.length()).insert(0, "(").append(")"); }
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * MEMBER_ID: {PK, ID, NotNull, INTEGER(10)} <br />
     * @return The value of the column 'MEMBER_ID'. (NullAllowed)
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * MEMBER_ID: {PK, ID, NotNull, INTEGER(10)} <br />
     * @param memberId The value of the column 'MEMBER_ID'. (NullAllowed)
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * MEMBER_NAME: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'MEMBER_NAME'. (NullAllowed)
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * MEMBER_NAME: {NotNull, VARCHAR(200)} <br />
     * @param memberName The value of the column 'MEMBER_NAME'. (NullAllowed)
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)} <br />
     * @return The value of the column 'MEMBER_ACCOUNT'. (NullAllowed)
     */
    public String getMemberAccount() {
        return memberAccount;
    }

    /**
     * MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)} <br />
     * @param memberAccount The value of the column 'MEMBER_ACCOUNT'. (NullAllowed)
     */
    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    /**
     * FORMALIZED_DATETIME: {TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'FORMALIZED_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getFormalizedDatetime() {
        return formalizedDatetime;
    }

    /**
     * FORMALIZED_DATETIME: {TIMESTAMP(23, 10)} <br />
     * @param formalizedDatetime The value of the column 'FORMALIZED_DATETIME'. (NullAllowed)
     */
    public void setFormalizedDatetime(java.sql.Timestamp formalizedDatetime) {
        this.formalizedDatetime = formalizedDatetime;
    }

    /**
     * BIRTHDATE: {DATE(8)} <br />
     * @return The value of the column 'BIRTHDATE'. (NullAllowed)
     */
    public java.util.Date getBirthdate() {
        return birthdate;
    }

    /**
     * BIRTHDATE: {DATE(8)} <br />
     * @param birthdate The value of the column 'BIRTHDATE'. (NullAllowed)
     */
    public void setBirthdate(java.util.Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'REGISTER_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getRegisterDatetime() {
        return registerDatetime;
    }

    /**
     * REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (NullAllowed)
     */
    public void setRegisterDatetime(java.sql.Timestamp registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    /**
     * REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'REGISTER_USER'. (NullAllowed)
     */
    public String getRegisterUser() {
        return registerUser;
    }

    /**
     * REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * @param registerUser The value of the column 'REGISTER_USER'. (NullAllowed)
     */
    public void setRegisterUser(String registerUser) {
        this.registerUser = registerUser;
    }

    /**
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'REGISTER_PROCESS'. (NullAllowed)
     */
    public String getRegisterProcess() {
        return registerProcess;
    }

    /**
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)} <br />
     * @param registerProcess The value of the column 'REGISTER_PROCESS'. (NullAllowed)
     */
    public void setRegisterProcess(String registerProcess) {
        this.registerProcess = registerProcess;
    }

    /**
     * UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'UPDATE_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (NullAllowed)
     */
    public void setUpdateDatetime(java.sql.Timestamp updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    /**
     * UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'UPDATE_USER'. (NullAllowed)
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * @param updateUser The value of the column 'UPDATE_USER'. (NullAllowed)
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'UPDATE_PROCESS'. (NullAllowed)
     */
    public String getUpdateProcess() {
        return updateProcess;
    }

    /**
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)} <br />
     * @param updateProcess The value of the column 'UPDATE_PROCESS'. (NullAllowed)
     */
    public void setUpdateProcess(String updateProcess) {
        this.updateProcess = updateProcess;
    }

    /**
     * VERSION_NO: {NotNull, BIGINT(19)} <br />
     * @return The value of the column 'VERSION_NO'. (NullAllowed)
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     * VERSION_NO: {NotNull, BIGINT(19)} <br />
     * @param versionNo The value of the column 'VERSION_NO'. (NullAllowed)
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }
}
