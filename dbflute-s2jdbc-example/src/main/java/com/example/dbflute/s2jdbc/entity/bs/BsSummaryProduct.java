package com.example.dbflute.s2jdbc.entity.bs;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The entity of SUMMARY_PRODUCT as VIEW. <br />
 * <pre>
 * [primary-key]
 *     
 * 
 * [column]
 *     PRODUCT_ID, PRODUCT_NAME, PRODUCT_HANDLE_CODE, PRODUCT_STATUS_CODE, LATEST_PURCHASE_DATETIME
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
public abstract class BsSummaryProduct implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * PRODUCT_ID: {INTEGER(10)} <br />
     */
    public Integer productId;

    /**
     * PRODUCT_NAME: {VARCHAR(50)} <br />
     */
    public String productName;

    /**
     * PRODUCT_HANDLE_CODE: {VARCHAR(100)} <br />
     */
    public String productHandleCode;

    /**
     * PRODUCT_STATUS_CODE: {CHAR(3)} <br />
     */
    public String productStatusCode;

    /**
     * LATEST_PURCHASE_DATETIME: {TIMESTAMP(23, 10)} <br />
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.sql.Timestamp latestPurchaseDatetime;

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
        sb.append(delimiter).append(productId);
        sb.append(delimiter).append(productName);
        sb.append(delimiter).append(productHandleCode);
        sb.append(delimiter).append(productStatusCode);
        sb.append(delimiter).append(latestPurchaseDatetime);
        if (sb.length() > 0) { sb.delete(0, delimiter.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
