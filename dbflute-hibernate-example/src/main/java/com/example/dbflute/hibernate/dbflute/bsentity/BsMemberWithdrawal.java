package com.example.dbflute.hibernate.dbflute.bsentity;

import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.hibernate.dbflute.allcommon.CommonColumnAutoSetupper;
import com.example.dbflute.hibernate.dbflute.allcommon.EntityDefinedCommonColumn;
import com.example.dbflute.hibernate.dbflute.exentity.Member;
import com.example.dbflute.hibernate.dbflute.exentity.WithdrawalReason;

/**
 * The entity of MEMBER_WITHDRAWAL as TABLE. <br />
 * <pre>
 * [primary-key]
 *     MEMBER_WITHDRAWAL_ID
 * 
 * [column]
 *     MEMBER_WITHDRAWAL_ID, MEMBER_ID, WITHDRAWAL_REASON_CODE, WITHDRAWAL_REASON_INPUT_TEXT, WITHDRAWAL_DATETIME, REGISTER_DATETIME, REGISTER_PROCESS, REGISTER_USER, UPDATE_DATETIME, UPDATE_PROCESS, UPDATE_USER, VERSION_NO
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
 *     MEMBER, WITHDRAWAL_REASON
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, withdrawalReason
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsMemberWithdrawal implements EntityDefinedCommonColumn, Serializable {

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
    /** Property for memberWithdrawalId column. {PK, NotNull, INTEGER(10)} */
    @Id
    @Column(name="MEMBER_WITHDRAWAL_ID")
    protected Integer memberWithdrawalId;
    
    /** Property for withdrawalReasonInputText column. {CLOB(2147483647)} */
    @Column(name="WITHDRAWAL_REASON_INPUT_TEXT")
    protected String withdrawalReasonInputText;
    
    /** Property for withdrawalDatetime column. {NotNull, TIMESTAMP(23, 10)} */
    @Column(name="WITHDRAWAL_DATETIME")
    protected java.sql.Timestamp withdrawalDatetime;
    
    /** Property for registerDatetime column. {NotNull, TIMESTAMP(23, 10)} */
    @Column(name="REGISTER_DATETIME")
    protected java.sql.Timestamp registerDatetime;
    
    /** Property for registerProcess column. {NotNull, VARCHAR(200)} */
    @Column(name="REGISTER_PROCESS")
    protected String registerProcess;
    
    /** Property for registerUser column. {NotNull, VARCHAR(200)} */
    @Column(name="REGISTER_USER")
    protected String registerUser;
    
    /** Property for updateDatetime column. {NotNull, TIMESTAMP(23, 10)} */
    @Column(name="UPDATE_DATETIME")
    protected java.sql.Timestamp updateDatetime;
    
    /** Property for updateProcess column. {NotNull, VARCHAR(200)} */
    @Column(name="UPDATE_PROCESS")
    protected String updateProcess;
    
    /** Property for updateUser column. {NotNull, VARCHAR(200)} */
    @Column(name="UPDATE_USER")
    protected String updateUser;
    
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
    //                                                                       Foreign Table
    //                                                                       =============
    /** MEMBER by my MEMBER_ID, named 'member'. */
    @OneToOne(fetch=FetchType.LAZY)
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

    /** WITHDRAWAL_REASON by my WITHDRAWAL_REASON_CODE, named 'withdrawalReason'. */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="WITHDRAWAL_REASON_CODE")
    protected WithdrawalReason withdrawalReason;

    /**
     * WITHDRAWAL_REASON by my WITHDRAWAL_REASON_CODE, named 'withdrawalReason'.
     * @return The entity of foreign property 'withdrawalReason'. (NullAllowed: If the foreign key does not have 'NotNull' constraint, please check null.)
     */
    public WithdrawalReason getWithdrawalReason() {
        return withdrawalReason;
    }

    /**
     * WITHDRAWAL_REASON by my WITHDRAWAL_REASON_CODE, named 'withdrawalReason'.
     * @param withdrawalReason The entity of foreign property 'withdrawalReason'. (NullAllowed)
     */
    public void setWithdrawalReason(WithdrawalReason withdrawalReason) {
        this.withdrawalReason = withdrawalReason;
    }

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
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
        if (other == null || !(other instanceof BsMemberWithdrawal)) { return false; }
        BsMemberWithdrawal otherEntity = (BsMemberWithdrawal)other;
        if (!helpComparingValue(getMemberWithdrawalId(), otherEntity.getMemberWithdrawalId())) { return false; }
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
        if (getMemberWithdrawalId() != null) { result = (31*result) + getMemberWithdrawalId().hashCode(); }
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
        if (withdrawalReason != null)
        { sb.append(l).append(xbRDS(withdrawalReason, "withdrawalReason")); }
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
        sb.append(c).append(memberWithdrawalId);
        sb.append(c).append(withdrawalReasonInputText);
        sb.append(c).append(withdrawalDatetime);
        sb.append(c).append(registerDatetime);
        sb.append(c).append(registerProcess);
        sb.append(c).append(registerUser);
        sb.append(c).append(updateDatetime);
        sb.append(c).append(updateProcess);
        sb.append(c).append(updateUser);
        sb.append(c).append(versionNo);
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    private String xbuildRelationString() {
        StringBuilder sb = new StringBuilder();
        String c = ",";
        if (member != null) { sb.append(c).append("member"); }
        if (withdrawalReason != null) { sb.append(c).append("withdrawalReason"); }
        if (sb.length() > 0) { sb.delete(0, c.length()).insert(0, "(").append(")"); }
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * MEMBER_WITHDRAWAL_ID: {PK, NotNull, INTEGER(10)} <br />
     * @return The value of the column 'MEMBER_WITHDRAWAL_ID'. (NullAllowed)
     */
    public Integer getMemberWithdrawalId() {
        return memberWithdrawalId;
    }

    /**
     * MEMBER_WITHDRAWAL_ID: {PK, NotNull, INTEGER(10)} <br />
     * @param memberWithdrawalId The value of the column 'MEMBER_WITHDRAWAL_ID'. (NullAllowed)
     */
    public void setMemberWithdrawalId(Integer memberWithdrawalId) {
        this.memberWithdrawalId = memberWithdrawalId;
    }

    /**
     * WITHDRAWAL_REASON_INPUT_TEXT: {CLOB(2147483647)} <br />
     * @return The value of the column 'WITHDRAWAL_REASON_INPUT_TEXT'. (NullAllowed)
     */
    public String getWithdrawalReasonInputText() {
        return withdrawalReasonInputText;
    }

    /**
     * WITHDRAWAL_REASON_INPUT_TEXT: {CLOB(2147483647)} <br />
     * @param withdrawalReasonInputText The value of the column 'WITHDRAWAL_REASON_INPUT_TEXT'. (NullAllowed)
     */
    public void setWithdrawalReasonInputText(String withdrawalReasonInputText) {
        this.withdrawalReasonInputText = withdrawalReasonInputText;
    }

    /**
     * WITHDRAWAL_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'WITHDRAWAL_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getWithdrawalDatetime() {
        return withdrawalDatetime;
    }

    /**
     * WITHDRAWAL_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @param withdrawalDatetime The value of the column 'WITHDRAWAL_DATETIME'. (NullAllowed)
     */
    public void setWithdrawalDatetime(java.sql.Timestamp withdrawalDatetime) {
        this.withdrawalDatetime = withdrawalDatetime;
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
