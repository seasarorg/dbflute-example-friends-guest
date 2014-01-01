package com.example.dbflute.hibernate.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.example.dbflute.hibernate.dbflute.allcommon.CommonColumnAutoSetupper;
import com.example.dbflute.hibernate.dbflute.allcommon.EntityDefinedCommonColumn;
import com.example.dbflute.hibernate.dbflute.exentity.ProductStatus;
import com.example.dbflute.hibernate.dbflute.exentity.Purchase;

/**
 * The entity of PRODUCT as TABLE. <br />
 * <pre>
 * [primary-key]
 *     PRODUCT_ID
 * 
 * [column]
 *     PRODUCT_ID, PRODUCT_NAME, PRODUCT_HANDLE_CODE, PRODUCT_STATUS_CODE, REGISTER_DATETIME, REGISTER_USER, REGISTER_PROCESS, UPDATE_DATETIME, UPDATE_USER, UPDATE_PROCESS, VERSION_NO
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
 *     PRODUCT_STATUS
 * 
 * [referrer-table]
 *     PURCHASE
 * 
 * [foreign-property]
 *     productStatus
 * 
 * [referrer-property]
 *     purchaseList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsProduct implements EntityDefinedCommonColumn, Serializable {

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
    /** Property for productId column. {PK, ID, NotNull, INTEGER(10)} */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRODUCT_ID")
    protected Integer productId;
    
    /** Property for productName column. {NotNull, VARCHAR(50)} */
    @Column(name="PRODUCT_NAME")
    protected String productName;
    
    /** Property for productHandleCode column. {UQ, NotNull, VARCHAR(100)} */
    @Column(name="PRODUCT_HANDLE_CODE")
    protected String productHandleCode;
    
    /** Property for registerDatetime column. {NotNull, TIMESTAMP(23, 10)} */
    @Column(name="REGISTER_DATETIME")
    protected java.sql.Timestamp registerDatetime;
    
    /** Property for registerUser column. {NotNull, VARCHAR(200)} */
    @Column(name="REGISTER_USER")
    protected String registerUser;
    
    /** Property for registerProcess column. {NotNull, VARCHAR(200)} */
    @Column(name="REGISTER_PROCESS")
    protected String registerProcess;
    
    /** Property for updateDatetime column. {NotNull, TIMESTAMP(23, 10)} */
    @Column(name="UPDATE_DATETIME")
    protected java.sql.Timestamp updateDatetime;
    
    /** Property for updateUser column. {NotNull, VARCHAR(200)} */
    @Column(name="UPDATE_USER")
    protected String updateUser;
    
    /** Property for updateProcess column. {NotNull, VARCHAR(200)} */
    @Column(name="UPDATE_PROCESS")
    protected String updateProcess;
    
    /** Property for versionNo column. {NotNull, BIGINT(19)} */
    @Version
    @Column(name="VERSION_NO")
    protected Long versionNo;
    
    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** Is common column auto set up effective? */
    @Transient
    protected boolean _canCommonColumnAutoSetup = true;

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    /** PRODUCT_STATUS by my PRODUCT_STATUS_CODE, named 'productStatus'. */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PRODUCT_STATUS_CODE")
    protected ProductStatus productStatus;

    /**
     * PRODUCT_STATUS by my PRODUCT_STATUS_CODE, named 'productStatus'.
     * @return The entity of foreign property 'productStatus'. (NullAllowed: If the foreign key does not have 'NotNull' constraint, please check null.)
     */
    public ProductStatus getProductStatus() {
        return productStatus;
    }

    /**
     * PRODUCT_STATUS by my PRODUCT_STATUS_CODE, named 'productStatus'.
     * @param productStatus The entity of foreign property 'productStatus'. (NullAllowed)
     */
    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    /** PURCHASE by PRODUCT_ID, named 'purchaseList'. */
    @OneToMany(mappedBy = "product", fetch=FetchType.LAZY)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    protected List<Purchase> purchaseList;

    /**
     * PURCHASE by PRODUCT_ID, named 'purchaseList'.
     * @return The entity list of referrer property 'purchaseList'. (NotNull: If it's not loaded yet, initializes the list instance of referrer as empty and returns it.)
     */
    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    /**
     * PURCHASE by PRODUCT_ID, named 'purchaseList'.
     * @param purchaseList The entity list of referrer property 'purchaseList'. (NullAllowed)
     */
    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    // ===================================================================================
    //                                                              Common Column Handling
    //                                                              ======================
    @PrePersist
    public void doPrePersist() {
        CommonColumnAutoSetupper setupper = createCommonColumnAutoSetupper();
        setupper.handleCommonColumnOfInsertIfNeeds(this);
    }

    @PreUpdate
    public void doPreUpdate() {
        CommonColumnAutoSetupper setupper = createCommonColumnAutoSetupper();
        setupper.handleCommonColumnOfUpdateIfNeeds(this);
    }

    protected CommonColumnAutoSetupper createCommonColumnAutoSetupper() {
        return new CommonColumnAutoSetupper();
    }

    /**
     * Enable common column auto set up. {for after disable because the default is enabled}
     */
    public void enableCommonColumnAutoSetup() {
        _canCommonColumnAutoSetup = true;
    }

    /**
     * Disables auto set-up of common columns.
     */
    public void disableCommonColumnAutoSetup() {
        _canCommonColumnAutoSetup = false;
    }
    
    /**
     * Can the entity set up common column by auto?
     * @return The determination, true or false.
     */
    public boolean canCommonColumnAutoSetup() { // for Framework
        return _canCommonColumnAutoSetup;
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
        if (other == null || !(other instanceof BsProduct)) { return false; }
        BsProduct otherEntity = (BsProduct)other;
        if (!helpComparingValue(getProductId(), otherEntity.getProductId())) { return false; }
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
        if (getProductId() != null) { result = (31*result) + getProductId().hashCode(); }
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
        if (productStatus != null)
        { sb.append(l).append(xbRDS(productStatus, "productStatus")); }
        if (purchaseList != null)
        { for (com.example.dbflute.hibernate.dbflute.allcommon.Entity e : purchaseList)
        { if (e != null) { sb.append(l).append(xbRDS(e, "purchaseList")); } } }
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
        sb.append(c).append(productId);
        sb.append(c).append(productName);
        sb.append(c).append(productHandleCode);
        sb.append(c).append(registerDatetime);
        sb.append(c).append(registerUser);
        sb.append(c).append(registerProcess);
        sb.append(c).append(updateDatetime);
        sb.append(c).append(updateUser);
        sb.append(c).append(updateProcess);
        sb.append(c).append(versionNo);
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    private String xbuildRelationString() {
        StringBuilder sb = new StringBuilder();
        String c = ",";
        if (productStatus != null) { sb.append(c).append("productStatus"); }
        if (purchaseList != null && !purchaseList.isEmpty())
        { sb.append(c).append("purchaseList"); }
        if (sb.length() > 0) { sb.delete(0, c.length()).insert(0, "(").append(")"); }
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)} <br />
     * @return The value of the column 'PRODUCT_ID'. (NullAllowed)
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)} <br />
     * @param productId The value of the column 'PRODUCT_ID'. (NullAllowed)
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * PRODUCT_NAME: {NotNull, VARCHAR(50)} <br />
     * @return The value of the column 'PRODUCT_NAME'. (NullAllowed)
     */
    public String getProductName() {
        return productName;
    }

    /**
     * PRODUCT_NAME: {NotNull, VARCHAR(50)} <br />
     * @param productName The value of the column 'PRODUCT_NAME'. (NullAllowed)
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * PRODUCT_HANDLE_CODE: {UQ, NotNull, VARCHAR(100)} <br />
     * @return The value of the column 'PRODUCT_HANDLE_CODE'. (NullAllowed)
     */
    public String getProductHandleCode() {
        return productHandleCode;
    }

    /**
     * PRODUCT_HANDLE_CODE: {UQ, NotNull, VARCHAR(100)} <br />
     * @param productHandleCode The value of the column 'PRODUCT_HANDLE_CODE'. (NullAllowed)
     */
    public void setProductHandleCode(String productHandleCode) {
        this.productHandleCode = productHandleCode;
    }

    /**
     * REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'REGISTER_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getRegisterDatetime() {
        return registerDatetime;
    }

    /**
     * REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (NullAllowed)
     */
    public void setRegisterDatetime(java.sql.Timestamp registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    /**
     * REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'REGISTER_USER'. (NullAllowed)
     */
    public String getRegisterUser() {
        return registerUser;
    }

    /**
     * REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * @param registerUser The value of the column 'REGISTER_USER'. (NullAllowed)
     */
    public void setRegisterUser(String registerUser) {
        this.registerUser = registerUser;
    }

    /**
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'REGISTER_PROCESS'. (NullAllowed)
     */
    public String getRegisterProcess() {
        return registerProcess;
    }

    /**
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)} <br />
     * @param registerProcess The value of the column 'REGISTER_PROCESS'. (NullAllowed)
     */
    public void setRegisterProcess(String registerProcess) {
        this.registerProcess = registerProcess;
    }

    /**
     * UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'UPDATE_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (NullAllowed)
     */
    public void setUpdateDatetime(java.sql.Timestamp updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    /**
     * UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'UPDATE_USER'. (NullAllowed)
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * @param updateUser The value of the column 'UPDATE_USER'. (NullAllowed)
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'UPDATE_PROCESS'. (NullAllowed)
     */
    public String getUpdateProcess() {
        return updateProcess;
    }

    /**
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)} <br />
     * @param updateProcess The value of the column 'UPDATE_PROCESS'. (NullAllowed)
     */
    public void setUpdateProcess(String updateProcess) {
        this.updateProcess = updateProcess;
    }

    /**
     * VERSION_NO: {NotNull, BIGINT(19)} <br />
     * @return The value of the column 'VERSION_NO'. (NullAllowed)
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     * VERSION_NO: {NotNull, BIGINT(19)} <br />
     * @param versionNo The value of the column 'VERSION_NO'. (NullAllowed)
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }
}
