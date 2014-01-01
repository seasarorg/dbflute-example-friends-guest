package com.example.dbflute.s2jdbc.entity.bs;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The entity of SUMMARY_WITHDRAWAL as VIEW. <br />
 * <pre>
 * [primary-key]
 *     
 * 
 * [column]
 *     MEMBER_ID, MEMBER_NAME, WITHDRAWAL_REASON_CODE, WITHDRAWAL_REASON_TEXT, WITHDRAWAL_REASON_INPUT_TEXT, WITHDRAWAL_DATETIME, MEMBER_STATUS_CODE, MEMBER_STATUS_NAME, MAX_PURCHASE_PRICE
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
 *     
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsSummaryWithdrawal implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * MEMBER_ID: {INTEGER(10)} <br />
     */
    public Integer memberId;

    /**
     * MEMBER_NAME: {VARCHAR(200)} <br />
     */
    public String memberName;

    /**
     * WITHDRAWAL_REASON_CODE: {CHAR(3)} <br />
     */
    public String withdrawalReasonCode;

    /**
     * WITHDRAWAL_REASON_TEXT: {CLOB(2147483647)} <br />
     */
    public String withdrawalReasonText;

    /**
     * WITHDRAWAL_REASON_INPUT_TEXT: {CLOB(2147483647)} <br />
     */
    public String withdrawalReasonInputText;

    /**
     * WITHDRAWAL_DATETIME: {TIMESTAMP(23, 10)} <br />
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.sql.Timestamp withdrawalDatetime;

    /**
     * MEMBER_STATUS_CODE: {CHAR(3)} <br />
     */
    public String memberStatusCode;

    /**
     * MEMBER_STATUS_NAME: {VARCHAR(50)} <br />
     */
    public String memberStatusName;

    /**
     * MAX_PURCHASE_PRICE: {INTEGER(10)} <br />
     */
    public Integer maxPurchasePrice;

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============

    /**
     * @return The view string of all columns. (NotNull)
     */
    public String toString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(memberId);
        sb.append(delimiter).append(memberName);
        sb.append(delimiter).append(withdrawalReasonCode);
        sb.append(delimiter).append(withdrawalReasonText);
        sb.append(delimiter).append(withdrawalReasonInputText);
        sb.append(delimiter).append(withdrawalDatetime);
        sb.append(delimiter).append(memberStatusCode);
        sb.append(delimiter).append(memberStatusName);
        sb.append(delimiter).append(maxPurchasePrice);
        if (sb.length() > 0) { sb.delete(0, delimiter.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
