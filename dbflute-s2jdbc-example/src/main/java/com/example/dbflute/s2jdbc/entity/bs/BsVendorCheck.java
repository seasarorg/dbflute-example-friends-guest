package com.example.dbflute.s2jdbc.entity.bs;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The entity of VENDOR_CHECK as TABLE. <br />
 * <pre>
 * [primary-key]
 *     VENDOR_CHECK_ID
 * 
 * [column]
 *     VENDOR_CHECK_ID, TYPE_OF_CHAR, TYPE_OF_VARCHAR, TYPE_OF_CLOB, TYPE_OF_TEXT, TYPE_OF_NUMERIC_INTEGER, TYPE_OF_NUMERIC_BIGINT, TYPE_OF_NUMERIC_DECIMAL, TYPE_OF_NUMERIC_INTEGER_MIN, TYPE_OF_NUMERIC_INTEGER_MAX, TYPE_OF_NUMERIC_BIGINT_MIN, TYPE_OF_NUMERIC_BIGINT_MAX, TYPE_OF_NUMERIC_SUPERINT_MIN, TYPE_OF_NUMERIC_SUPERINT_MAX, TYPE_OF_NUMERIC_MAXDECIMAL, TYPE_OF_INTEGER, TYPE_OF_BIGINT, TYPE_OF_DATE, TYPE_OF_TIMESTAMP, TYPE_OF_TIME, TYPE_OF_BOOLEAN, TYPE_OF_BINARY, TYPE_OF_BLOB, TYPE_OF_UUID, TYPE_OF_ARRAY, TYPE_OF_OTHER, U_Y_TEXT
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
public abstract class BsVendorCheck implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)} <br />
     */
    @Id
    public java.math.BigDecimal vendorCheckId;

    /**
     * TYPE_OF_CHAR: {CHAR(3)} <br />
     */
    public String typeOfChar;

    /**
     * TYPE_OF_VARCHAR: {VARCHAR(32)} <br />
     */
    public String typeOfVarchar;

    /**
     * TYPE_OF_CLOB: {CLOB(2147483647)} <br />
     */
    public String typeOfClob;

    /**
     * TYPE_OF_TEXT: {CLOB(2147483647)} <br />
     */
    public String typeOfText;

    /**
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)} <br />
     */
    public java.math.BigDecimal typeOfNumericInteger;

    /**
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)} <br />
     */
    public java.math.BigDecimal typeOfNumericBigint;

    /**
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)} <br />
     */
    public java.math.BigDecimal typeOfNumericDecimal;

    /**
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)} <br />
     */
    public java.math.BigDecimal typeOfNumericIntegerMin;

    /**
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)} <br />
     */
    public java.math.BigDecimal typeOfNumericIntegerMax;

    /**
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)} <br />
     */
    public java.math.BigDecimal typeOfNumericBigintMin;

    /**
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)} <br />
     */
    public java.math.BigDecimal typeOfNumericBigintMax;

    /**
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)} <br />
     */
    public java.math.BigDecimal typeOfNumericSuperintMin;

    /**
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)} <br />
     */
    public java.math.BigDecimal typeOfNumericSuperintMax;

    /**
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)} <br />
     */
    public java.math.BigDecimal typeOfNumericMaxdecimal;

    /**
     * TYPE_OF_INTEGER: {INTEGER(10)} <br />
     */
    public Integer typeOfInteger;

    /**
     * TYPE_OF_BIGINT: {BIGINT(19)} <br />
     */
    public Long typeOfBigint;

    /**
     * TYPE_OF_DATE: {DATE(8)} <br />
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    public java.util.Date typeOfDate;

    /**
     * TYPE_OF_TIMESTAMP: {TIMESTAMP(23, 10)} <br />
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.sql.Timestamp typeOfTimestamp;

    /**
     * TYPE_OF_TIME: {TIME(6)} <br />
     */
    @Temporal(javax.persistence.TemporalType.TIME)
    public java.sql.Time typeOfTime;

    /**
     * TYPE_OF_BOOLEAN: {BOOLEAN(1)} <br />
     */
    public Boolean typeOfBoolean;

    /**
     * TYPE_OF_BINARY: {VARBINARY(2147483647)} <br />
     */
    public byte[] typeOfBinary;

    /**
     * TYPE_OF_BLOB: {BLOB(2147483647)} <br />
     */
    public byte[] typeOfBlob;

    /**
     * TYPE_OF_UUID: {UUID(2147483647)} <br />
     */
    public byte[] typeOfUuid;

    /**
     * TYPE_OF_ARRAY: {ARRAY} <br />
     */
    public String typeOfArray;

    /**
     * TYPE_OF_OTHER: {OTHER(2147483647)} <br />
     */
    public String typeOfOther;

    /**
     * U_Y_TEXT: {CLOB(2147483647)} <br />
     */
    public String uYText;

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
        if (!helpComparingValue(vendorCheckId, otherEntity.vendorCheckId)) { return false; }
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
        if (vendorCheckId != null) { result = (31*result) + vendorCheckId.hashCode(); }
        return result;
    }

    /**
     * @return The view string of all columns. (NotNull)
     */
    public String toString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(vendorCheckId);
        sb.append(delimiter).append(typeOfChar);
        sb.append(delimiter).append(typeOfVarchar);
        sb.append(delimiter).append(typeOfClob);
        sb.append(delimiter).append(typeOfText);
        sb.append(delimiter).append(typeOfNumericInteger);
        sb.append(delimiter).append(typeOfNumericBigint);
        sb.append(delimiter).append(typeOfNumericDecimal);
        sb.append(delimiter).append(typeOfNumericIntegerMin);
        sb.append(delimiter).append(typeOfNumericIntegerMax);
        sb.append(delimiter).append(typeOfNumericBigintMin);
        sb.append(delimiter).append(typeOfNumericBigintMax);
        sb.append(delimiter).append(typeOfNumericSuperintMin);
        sb.append(delimiter).append(typeOfNumericSuperintMax);
        sb.append(delimiter).append(typeOfNumericMaxdecimal);
        sb.append(delimiter).append(typeOfInteger);
        sb.append(delimiter).append(typeOfBigint);
        sb.append(delimiter).append(typeOfDate);
        sb.append(delimiter).append(typeOfTimestamp);
        sb.append(delimiter).append(typeOfTime);
        sb.append(delimiter).append(typeOfBoolean);
        sb.append(delimiter).append(typeOfBinary);
        sb.append(delimiter).append(typeOfBlob);
        sb.append(delimiter).append(typeOfUuid);
        sb.append(delimiter).append(typeOfArray);
        sb.append(delimiter).append(typeOfOther);
        sb.append(delimiter).append(uYText);
        if (sb.length() > 0) { sb.delete(0, delimiter.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
