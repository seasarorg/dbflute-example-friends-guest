package com.example.dbflute.s2jdbc.entity.bs;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.s2jdbc.entity.*;

/**
 * The entity of (商品ステータス)PRODUCT_STATUS as TABLE. <br />
 * 商品のステータスを表現する固定的なマスタ。
 * <pre>
 * [primary-key]
 *     PRODUCT_STATUS_CODE
 * 
 * [column]
 *     PRODUCT_STATUS_CODE, PRODUCT_STATUS_NAME, DISPLAY_ORDER
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
 *     PRODUCT
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     productList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsProductStatus implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3)} <br />
     * 商品ステータスを識別するコード。
     */
    @Id
    public String productStatusCode;

    /**
     * PRODUCT_STATUS_NAME: {NotNull, VARCHAR(50)} <br />
     */
    public String productStatusName;

    /**
     * DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)} <br />
     */
    public Integer displayOrder;

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    /**
     * (商品)PRODUCT by PRODUCT_STATUS_CODE, named 'productList'.
     */
    @OneToMany(mappedBy = "productStatus")
    public List<Product> productList;

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * If the primary-key of the other is same as this one, returns true.
     * @param other Other entity.
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsProductStatus)) { return false; }
        BsProductStatus otherEntity = (BsProductStatus)other;
        if (!helpComparingValue(productStatusCode, otherEntity.productStatusCode)) { return false; }
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
        if (productStatusCode != null) { result = (31*result) + productStatusCode.hashCode(); }
        return result;
    }

    /**
     * @return The view string of all columns. (NotNull)
     */
    public String toString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(productStatusCode);
        sb.append(delimiter).append(productStatusName);
        sb.append(delimiter).append(displayOrder);
        if (sb.length() > 0) { sb.delete(0, delimiter.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
