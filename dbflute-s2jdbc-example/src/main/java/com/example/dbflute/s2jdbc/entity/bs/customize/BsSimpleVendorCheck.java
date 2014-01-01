package com.example.dbflute.s2jdbc.entity.bs.customize;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The entity of SimpleVendorCheck. <br />
 * <pre>
 * [primary-key]
 *     
 * 
 * [column]
 *     VENDOR_CHECK_ID, DECIMAL_DIGIT, INTEGER_NON_DIGIT, LARGE_CHARACTER
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
public abstract class BsSimpleVendorCheck implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** Property for vendorCheckId column. {DECIMAL(16), refers to VENDOR_CHECK.VENDOR_CHECK_ID} */
    public java.math.BigDecimal vendorCheckId;
    
    /** Property for decimalDigit column. {DECIMAL(5, 3), refers to VENDOR_CHECK.DECIMAL_DIGIT} */
    public java.math.BigDecimal decimalDigit;
    
    /** Property for integerNonDigit column. {DECIMAL(5), refers to VENDOR_CHECK.INTEGER_NON_DIGIT} */
    public java.math.BigDecimal integerNonDigit;
    
    /** Property for largeCharacter column. {CLOB(2147483647), refers to VENDOR_CHECK.LARGE_CHARACTER} */
    public String largeCharacter;
    
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
        sb.append(delimiter).append(vendorCheckId);
        sb.append(delimiter).append(decimalDigit);
        sb.append(delimiter).append(integerNonDigit);
        sb.append(delimiter).append(largeCharacter);
        if (sb.length() > 0) { sb.delete(0, delimiter.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
