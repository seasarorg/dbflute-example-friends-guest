package com.example.dbflute.hibernate.dbflute.bsentity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The entity of VENDOR_CHECK as TABLE. <br />
 * <pre>
 * [primary-key]
 *     VENDOR_CHECK_ID
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
public abstract class BsVendorCheck implements com.example.dbflute.hibernate.dbflute.allcommon.Entity, Serializable {

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
    /** Property for vendorCheckId column. {PK, NotNull, DECIMAL(16)} */
    @Id
    @Column(name="VENDOR_CHECK_ID")
    protected java.math.BigDecimal vendorCheckId;
    
    /** Property for decimalDigit column. {NotNull, DECIMAL(5, 3)} */
    @Column(name="DECIMAL_DIGIT")
    protected java.math.BigDecimal decimalDigit;
    
    /** Property for integerNonDigit column. {NotNull, DECIMAL(5)} */
    @Column(name="INTEGER_NON_DIGIT")
    protected java.math.BigDecimal integerNonDigit;
    
    /** Property for largeCharacter column. {NotNull, CLOB(2147483647)} */
    @Column(name="LARGE_CHARACTER")
    protected String largeCharacter;
    
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
     * If the primary-key of the other is same as this one, returns true.
     * @param other Other entity.
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsVendorCheck)) { return false; }
        BsVendorCheck otherEntity = (BsVendorCheck)other;
        if (!helpComparingValue(getVendorCheckId(), otherEntity.getVendorCheckId())) { return false; }
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
        if (getVendorCheckId() != null) { result = (31*result) + getVendorCheckId().hashCode(); }
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
        return sb.toString();
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
        sb.append(c).append(vendorCheckId);
        sb.append(c).append(decimalDigit);
        sb.append(c).append(integerNonDigit);
        sb.append(c).append(largeCharacter);
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    private String xbuildRelationString() {
        return "";
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)} <br />
     * @return The value of the column 'VENDOR_CHECK_ID'. (NullAllowed)
     */
    public java.math.BigDecimal getVendorCheckId() {
        return vendorCheckId;
    }

    /**
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)} <br />
     * @param vendorCheckId The value of the column 'VENDOR_CHECK_ID'. (NullAllowed)
     */
    public void setVendorCheckId(java.math.BigDecimal vendorCheckId) {
        this.vendorCheckId = vendorCheckId;
    }

    /**
     * DECIMAL_DIGIT: {NotNull, DECIMAL(5, 3)} <br />
     * @return The value of the column 'DECIMAL_DIGIT'. (NullAllowed)
     */
    public java.math.BigDecimal getDecimalDigit() {
        return decimalDigit;
    }

    /**
     * DECIMAL_DIGIT: {NotNull, DECIMAL(5, 3)} <br />
     * @param decimalDigit The value of the column 'DECIMAL_DIGIT'. (NullAllowed)
     */
    public void setDecimalDigit(java.math.BigDecimal decimalDigit) {
        this.decimalDigit = decimalDigit;
    }

    /**
     * INTEGER_NON_DIGIT: {NotNull, DECIMAL(5)} <br />
     * @return The value of the column 'INTEGER_NON_DIGIT'. (NullAllowed)
     */
    public java.math.BigDecimal getIntegerNonDigit() {
        return integerNonDigit;
    }

    /**
     * INTEGER_NON_DIGIT: {NotNull, DECIMAL(5)} <br />
     * @param integerNonDigit The value of the column 'INTEGER_NON_DIGIT'. (NullAllowed)
     */
    public void setIntegerNonDigit(java.math.BigDecimal integerNonDigit) {
        this.integerNonDigit = integerNonDigit;
    }

    /**
     * LARGE_CHARACTER: {NotNull, CLOB(2147483647)} <br />
     * @return The value of the column 'LARGE_CHARACTER'. (NullAllowed)
     */
    public String getLargeCharacter() {
        return largeCharacter;
    }

    /**
     * LARGE_CHARACTER: {NotNull, CLOB(2147483647)} <br />
     * @param largeCharacter The value of the column 'LARGE_CHARACTER'. (NullAllowed)
     */
    public void setLargeCharacter(String largeCharacter) {
        this.largeCharacter = largeCharacter;
    }
}
