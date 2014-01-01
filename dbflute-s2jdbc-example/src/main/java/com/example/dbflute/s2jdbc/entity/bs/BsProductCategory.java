package com.example.dbflute.s2jdbc.entity.bs;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.s2jdbc.entity.*;

/**
 * The entity of (商品カテゴリ)PRODUCT_CATEGORY as TABLE. <br />
 * 商品のカテゴリを表現するマスタ。<br />
 * 自己参照の階層になっている。
 * <pre>
 * [primary-key]
 *     PRODUCT_CATEGORY_CODE
 * 
 * [column]
 *     PRODUCT_CATEGORY_CODE, PRODUCT_CATEGORY_NAME, PARENT_CATEGORY_CODE
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
 *     PRODUCT_CATEGORY
 * 
 * [referrer-table]
 *     PRODUCT, PRODUCT_CATEGORY
 * 
 * [foreign-property]
 *     productCategorySelf
 * 
 * [referrer-property]
 *     productList, productCategorySelfList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsProductCategory implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * (商品カテゴリコード)PRODUCT_CATEGORY_CODE: {PK, NotNull, CHAR(3)} <br />
     */
    @Id
    public String productCategoryCode;

    /**
     * (商品カテゴリ名称)PRODUCT_CATEGORY_NAME: {NotNull, VARCHAR(50)} <br />
     */
    public String productCategoryName;

    /**
     * (親カテゴリコード)PARENT_CATEGORY_CODE: {IX, CHAR(3), FK to PRODUCT_CATEGORY} <br />
     * 最上位の場合はデータなし。
     */
    public String parentCategoryCode;

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    /**
     * (商品カテゴリ)PRODUCT_CATEGORY by my PARENT_CATEGORY_CODE, named 'productCategorySelf'.
     */
    @ManyToOne
    @JoinColumn(name="PARENT_CATEGORY_CODE")
    public ProductCategory productCategorySelf;

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    /**
     * (商品)PRODUCT by PRODUCT_CATEGORY_CODE, named 'productList'.
     */
    @OneToMany(mappedBy = "productCategory")
    public List<Product> productList;

    /**
     * (商品カテゴリ)PRODUCT_CATEGORY by PARENT_CATEGORY_CODE, named 'productCategorySelfList'.
     */
    @OneToMany(mappedBy = "productCategorySelf")
    public List<ProductCategory> productCategorySelfList;

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * If the primary-key of the other is same as this one, returns true.
     * @param other Other entity.
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsProductCategory)) { return false; }
        BsProductCategory otherEntity = (BsProductCategory)other;
        if (!helpComparingValue(productCategoryCode, otherEntity.productCategoryCode)) { return false; }
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
        if (productCategoryCode != null) { result = (31*result) + productCategoryCode.hashCode(); }
        return result;
    }

    /**
     * @return The view string of all columns. (NotNull)
     */
    public String toString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(productCategoryCode);
        sb.append(delimiter).append(productCategoryName);
        sb.append(delimiter).append(parentCategoryCode);
        if (sb.length() > 0) { sb.delete(0, delimiter.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
