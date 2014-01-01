package com.example.dbflute.s2jdbc.entity.bs;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.s2jdbc.entity.*;

/**
 * The entity of (商品)PRODUCT as TABLE. <br />
 * <pre>
 * [primary-key]
 *     PRODUCT_ID
 * 
 * [column]
 *     PRODUCT_ID, PRODUCT_NAME, PRODUCT_HANDLE_CODE, PRODUCT_CATEGORY_CODE, PRODUCT_STATUS_CODE, REGULAR_PRICE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     PRODUCT_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     PRODUCT_CATEGORY, PRODUCT_STATUS
 * 
 * [referrer-table]
 *     PURCHASE
 * 
 * [foreign-property]
 *     productCategory, productStatus
 * 
 * [referrer-property]
 *     purchaseList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsProduct implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)} <br />
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer productId;

    /**
     * (商品名称)PRODUCT_NAME: {IX, NotNull, VARCHAR(50)} <br />
     * ExampleDBとして、コメントの少ないケースを表現するため、<br />
     * あえてコメントを控えている。実業務ではしっかりとコメントを<br />
     * 入れることが強く強く推奨される。
     */
    public String productName;

    /**
     * (商品ハンドルコード)PRODUCT_HANDLE_CODE: {UQ, NotNull, VARCHAR(100)} <br />
     * 商品を識別する業務上のコード。
     */
    public String productHandleCode;

    /**
     * PRODUCT_CATEGORY_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_CATEGORY} <br />
     */
    public String productCategoryCode;

    /**
     * PRODUCT_STATUS_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_STATUS} <br />
     */
    public String productStatusCode;

    /**
     * REGULAR_PRICE: {NotNull, INTEGER(10)} <br />
     */
    public Integer regularPrice;

    /**
     * REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.sql.Timestamp registerDatetime;

    /**
     * REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     */
    public String registerUser;

    /**
     * UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.sql.Timestamp updateDatetime;

    /**
     * UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     */
    public String updateUser;

    /**
     * VERSION_NO: {NotNull, BIGINT(19)} <br />
     */
    @Version
    public Long versionNo;

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    /**
     * (商品カテゴリ)PRODUCT_CATEGORY by my PRODUCT_CATEGORY_CODE, named 'productCategory'.
     */
    @ManyToOne
    @JoinColumn(name="PRODUCT_CATEGORY_CODE")
    public ProductCategory productCategory;

    /**
     * (商品ステータス)PRODUCT_STATUS by my PRODUCT_STATUS_CODE, named 'productStatus'.
     */
    @ManyToOne
    @JoinColumn(name="PRODUCT_STATUS_CODE")
    public ProductStatus productStatus;

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    /**
     * (購入)PURCHASE by PRODUCT_ID, named 'purchaseList'.
     */
    @OneToMany(mappedBy = "product")
    public List<Purchase> purchaseList;

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * If the primary-key of the other is same as this one, returns true.
     * @param other Other entity.
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsProduct)) { return false; }
        BsProduct otherEntity = (BsProduct)other;
        if (!helpComparingValue(productId, otherEntity.productId)) { return false; }
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
        if (productId != null) { result = (31*result) + productId.hashCode(); }
        return result;
    }

    /**
     * @return The view string of all columns. (NotNull)
     */
    public String toString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(productId);
        sb.append(delimiter).append(productName);
        sb.append(delimiter).append(productHandleCode);
        sb.append(delimiter).append(productCategoryCode);
        sb.append(delimiter).append(productStatusCode);
        sb.append(delimiter).append(regularPrice);
        sb.append(delimiter).append(registerDatetime);
        sb.append(delimiter).append(registerUser);
        sb.append(delimiter).append(updateDatetime);
        sb.append(delimiter).append(updateUser);
        sb.append(delimiter).append(versionNo);
        if (sb.length() > 0) { sb.delete(0, delimiter.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
