package com.example.dbflute.hibernate.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.example.dbflute.hibernate.dbflute.exentity.Product;

/**
 * The entity of PRODUCT_STATUS as TABLE. <br />
 * <pre>
 * [primary-key]
 *     PRODUCT_STATUS_CODE
 * 
 * [column]
 *     PRODUCT_STATUS_CODE, PRODUCT_STATUS_NAME
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
public abstract class BsProductStatus implements com.example.dbflute.hibernate.dbflute.allcommon.Entity, Serializable {

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
    /** Property for productStatusCode column. {PK, NotNull, CHAR(3)} */
    @Id
    @Column(name="PRODUCT_STATUS_CODE")
    protected String productStatusCode;
    
    /** Property for productStatusName column. {UQ, NotNull, VARCHAR(50)} */
    @Column(name="PRODUCT_STATUS_NAME")
    protected String productStatusName;
    
    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    /** PRODUCT by PRODUCT_STATUS_CODE, named 'productList'. */
    @OneToMany(mappedBy = "productStatus", fetch=FetchType.LAZY)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    protected List<Product> productList;

    /**
     * PRODUCT by PRODUCT_STATUS_CODE, named 'productList'.
     * @return The entity list of referrer property 'productList'. (NotNull: If it's not loaded yet, initializes the list instance of referrer as empty and returns it.)
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * PRODUCT by PRODUCT_STATUS_CODE, named 'productList'.
     * @param productList The entity list of referrer property 'productList'. (NullAllowed)
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
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
        if (other == null || !(other instanceof BsProductStatus)) { return false; }
        BsProductStatus otherEntity = (BsProductStatus)other;
        if (!helpComparingValue(getProductStatusCode(), otherEntity.getProductStatusCode())) { return false; }
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
        if (getProductStatusCode() != null) { result = (31*result) + getProductStatusCode().hashCode(); }
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
        if (productList != null)
        { for (com.example.dbflute.hibernate.dbflute.allcommon.Entity e : productList)
        { if (e != null) { sb.append(l).append(xbRDS(e, "productList")); } } }
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
        sb.append(c).append(productStatusCode);
        sb.append(c).append(productStatusName);
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    private String xbuildRelationString() {
        StringBuilder sb = new StringBuilder();
        String c = ",";
        if (productList != null && !productList.isEmpty())
        { sb.append(c).append("productList"); }
        if (sb.length() > 0) { sb.delete(0, c.length()).insert(0, "(").append(")"); }
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3)} <br />
     * @return The value of the column 'PRODUCT_STATUS_CODE'. (NullAllowed)
     */
    public String getProductStatusCode() {
        return productStatusCode;
    }

    /**
     * PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3)} <br />
     * @param productStatusCode The value of the column 'PRODUCT_STATUS_CODE'. (NullAllowed)
     */
    public void setProductStatusCode(String productStatusCode) {
        this.productStatusCode = productStatusCode;
    }

    /**
     * PRODUCT_STATUS_NAME: {UQ, NotNull, VARCHAR(50)} <br />
     * @return The value of the column 'PRODUCT_STATUS_NAME'. (NullAllowed)
     */
    public String getProductStatusName() {
        return productStatusName;
    }

    /**
     * PRODUCT_STATUS_NAME: {UQ, NotNull, VARCHAR(50)} <br />
     * @param productStatusName The value of the column 'PRODUCT_STATUS_NAME'. (NullAllowed)
     */
    public void setProductStatusName(String productStatusName) {
        this.productStatusName = productStatusName;
    }
}
