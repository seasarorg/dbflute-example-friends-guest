package com.example.dbflute.hibernate.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.example.dbflute.hibernate.dbflute.exentity.MemberWithdrawal;

/**
 * The entity of WITHDRAWAL_REASON as TABLE. <br />
 * <pre>
 * [primary-key]
 *     WITHDRAWAL_REASON_CODE
 * 
 * [column]
 *     WITHDRAWAL_REASON_CODE, WITHDRAWAL_REASON_TEXT, DISPLAY_ORDER
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
 *     MEMBER_WITHDRAWAL
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     memberWithdrawalList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsWithdrawalReason implements com.example.dbflute.hibernate.dbflute.allcommon.Entity, Serializable {

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
    /** Property for withdrawalReasonCode column. {PK, NotNull, CHAR(3)} */
    @Id
    @Column(name="WITHDRAWAL_REASON_CODE")
    protected String withdrawalReasonCode;
    
    /** Property for withdrawalReasonText column. {NotNull, CLOB(2147483647)} */
    @Column(name="WITHDRAWAL_REASON_TEXT")
    protected String withdrawalReasonText;
    
    /** Property for displayOrder column. {UQ, NotNull, INTEGER(10)} */
    @Column(name="DISPLAY_ORDER")
    protected Integer displayOrder;
    
    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    /** MEMBER_WITHDRAWAL by WITHDRAWAL_REASON_CODE, named 'memberWithdrawalList'. */
    @OneToMany(mappedBy = "withdrawalReason", fetch=FetchType.LAZY)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    protected List<MemberWithdrawal> memberWithdrawalList;

    /**
     * MEMBER_WITHDRAWAL by WITHDRAWAL_REASON_CODE, named 'memberWithdrawalList'.
     * @return The entity list of referrer property 'memberWithdrawalList'. (NotNull: If it's not loaded yet, initializes the list instance of referrer as empty and returns it.)
     */
    public List<MemberWithdrawal> getMemberWithdrawalList() {
        return memberWithdrawalList;
    }

    /**
     * MEMBER_WITHDRAWAL by WITHDRAWAL_REASON_CODE, named 'memberWithdrawalList'.
     * @param memberWithdrawalList The entity list of referrer property 'memberWithdrawalList'. (NullAllowed)
     */
    public void setMemberWithdrawalList(List<MemberWithdrawal> memberWithdrawalList) {
        this.memberWithdrawalList = memberWithdrawalList;
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
        if (other == null || !(other instanceof BsWithdrawalReason)) { return false; }
        BsWithdrawalReason otherEntity = (BsWithdrawalReason)other;
        if (!helpComparingValue(getWithdrawalReasonCode(), otherEntity.getWithdrawalReasonCode())) { return false; }
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
        if (getWithdrawalReasonCode() != null) { result = (31*result) + getWithdrawalReasonCode().hashCode(); }
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
        if (memberWithdrawalList != null)
        { for (com.example.dbflute.hibernate.dbflute.allcommon.Entity e : memberWithdrawalList)
        { if (e != null) { sb.append(l).append(xbRDS(e, "memberWithdrawalList")); } } }
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
        sb.append(c).append(withdrawalReasonCode);
        sb.append(c).append(withdrawalReasonText);
        sb.append(c).append(displayOrder);
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    private String xbuildRelationString() {
        StringBuilder sb = new StringBuilder();
        String c = ",";
        if (memberWithdrawalList != null && !memberWithdrawalList.isEmpty())
        { sb.append(c).append("memberWithdrawalList"); }
        if (sb.length() > 0) { sb.delete(0, c.length()).insert(0, "(").append(")"); }
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * WITHDRAWAL_REASON_CODE: {PK, NotNull, CHAR(3)} <br />
     * @return The value of the column 'WITHDRAWAL_REASON_CODE'. (NullAllowed)
     */
    public String getWithdrawalReasonCode() {
        return withdrawalReasonCode;
    }

    /**
     * WITHDRAWAL_REASON_CODE: {PK, NotNull, CHAR(3)} <br />
     * @param withdrawalReasonCode The value of the column 'WITHDRAWAL_REASON_CODE'. (NullAllowed)
     */
    public void setWithdrawalReasonCode(String withdrawalReasonCode) {
        this.withdrawalReasonCode = withdrawalReasonCode;
    }

    /**
     * WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)} <br />
     * @return The value of the column 'WITHDRAWAL_REASON_TEXT'. (NullAllowed)
     */
    public String getWithdrawalReasonText() {
        return withdrawalReasonText;
    }

    /**
     * WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)} <br />
     * @param withdrawalReasonText The value of the column 'WITHDRAWAL_REASON_TEXT'. (NullAllowed)
     */
    public void setWithdrawalReasonText(String withdrawalReasonText) {
        this.withdrawalReasonText = withdrawalReasonText;
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
