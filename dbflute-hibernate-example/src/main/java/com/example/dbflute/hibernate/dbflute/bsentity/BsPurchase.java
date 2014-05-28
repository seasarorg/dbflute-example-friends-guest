package com.example.dbflute.hibernate.dbflute.bsentity;

import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.hibernate.dbflute.allcommon.CommonColumnAutoSetupper;
import com.example.dbflute.hibernate.dbflute.allcommon.EntityDefinedCommonColumn;
import com.example.dbflute.hibernate.dbflute.allcommon.CDef;
import com.example.dbflute.hibernate.dbflute.exentity.Member;
import com.example.dbflute.hibernate.dbflute.exentity.Product;

/**
 * The entity of PURCHASE as TABLE. <br />
 * <pre>
 * [primary-key]
 *     PURCHASE_ID
 * 
 * [column]
 *     PURCHASE_ID, MEMBER_ID, PRODUCT_ID, PURCHASE_DATETIME, PURCHASE_COUNT, PURCHASE_PRICE, PAYMENT_COMPLETE_FLG, REGISTER_DATETIME, REGISTER_USER, REGISTER_PROCESS, UPDATE_DATETIME, UPDATE_USER, UPDATE_PROCESS, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     PURCHASE_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER, PRODUCT
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, product
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsPurchase implements EntityDefinedCommonColumn, Serializable {

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
    /** Property for purchaseId column. {PK, ID, NotNull, BIGINT(19)} */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PURCHASE_ID")
    protected Long purchaseId;
    
    /** Property for purchaseDatetime column. {+UQ, NotNull, TIMESTAMP(23, 10)} */
    @Column(name="PURCHASE_DATETIME")
    protected java.sql.Timestamp purchaseDatetime;
    
    /** Property for purchaseCount column. {NotNull, INTEGER(10)} */
    @Column(name="PURCHASE_COUNT")
    protected Integer purchaseCount;
    
    /** Property for purchasePrice column. {NotNull, INTEGER(10)} */
    @Column(name="PURCHASE_PRICE")
    protected Integer purchasePrice;
    
    /** Property for paymentCompleteFlg column. {NotNull, INTEGER(10), classification=Flg} */
    @Column(name="PAYMENT_COMPLETE_FLG")
    protected Integer paymentCompleteFlg;
    
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
    //                                                          Classification Classifying
    //                                                          ==========================
    /**
     * Classify the value of paymentCompleteFlg as the classification of Flg. <br />
     * フラグを示す
     * @param cls The value of paymentCompleteFlg as the classification of Flg. (NullAllowed)
     */
    public void classifyPaymentCompleteFlg(CDef.Flg cls) {
        setPaymentCompleteFlg(cls != null ? Integer.valueOf(cls.code()) : null);
    }

    /**
     * Classify the value of paymentCompleteFlg as True. <br />
     * はい: 有効を示す
     */
    public void classifyPaymentCompleteFlgTrue() {
        classifyPaymentCompleteFlg(CDef.Flg.True);
    }

    /**
     * Classify the value of paymentCompleteFlg as False. <br />
     * いいえ: 無効を示す
     */
    public void classifyPaymentCompleteFlgFalse() {
        classifyPaymentCompleteFlg(CDef.Flg.False);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Get the value of paymentCompleteFlg as the classification of Flg. <br />
     * フラグを示す
     * @return The value of paymentCompleteFlg as the classification of Flg. (NullAllowed)
     */
    public CDef.Flg getPaymentCompleteFlgAsFlg() {
        return CDef.Flg.codeOf(paymentCompleteFlg);
    }

    /**
     * Is the value of paymentCompleteFlg 'True'? <br />
     * はい: 有効を示す
     * <p>
     * The difference of capital letters and small letters is NOT distinguished.
     * If the value is null, this method returns false!
     * </p>
     * @return The determination, true or false.
     */
    public boolean isPaymentCompleteFlgTrue() {
        CDef.Flg cls = getPaymentCompleteFlgAsFlg();
        return cls != null ? cls.equals(CDef.Flg.True) : false;
    }

    /**
     * Is the value of paymentCompleteFlg 'False'? <br />
     * いいえ: 無効を示す
     * <p>
     * The difference of capital letters and small letters is NOT distinguished.
     * If the value is null, this method returns false!
     * </p>
     * @return The determination, true or false.
     */
    public boolean isPaymentCompleteFlgFalse() {
        CDef.Flg cls = getPaymentCompleteFlgAsFlg();
        return cls != null ? cls.equals(CDef.Flg.False) : false;
    }

    // ===================================================================================
    //                                                           Classification Name/Alias
    //                                                           =========================
    /**
     * Get the value of the column 'paymentCompleteFlg' as classification name.
     * @return The value of the column 'paymentCompleteFlg' as classification name. (NullAllowed)
     */
    public String getPaymentCompleteFlgName() {
        CDef.Flg cls = getPaymentCompleteFlgAsFlg();
        return cls != null ? cls.name() : null;
    }

    /**
     * Get the value of the column 'paymentCompleteFlg' as classification alias.
     * @return The value of the column 'paymentCompleteFlg' as classification alias. (NullAllowed)
     */
    public String getPaymentCompleteFlgAlias() {
        CDef.Flg cls = getPaymentCompleteFlgAsFlg();
        return cls != null ? cls.alias() : null;
    }

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    /** MEMBER by my MEMBER_ID, named 'member'. */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    protected Member member;

    /**
     * MEMBER by my MEMBER_ID, named 'member'.
     * @return The entity of foreign property 'member'. (NullAllowed: If the foreign key does not have 'NotNull' constraint, please check null.)
     */
    public Member getMember() {
        return member;
    }

    /**
     * MEMBER by my MEMBER_ID, named 'member'.
     * @param member The entity of foreign property 'member'. (NullAllowed)
     */
    public void setMember(Member member) {
        this.member = member;
    }

    /** PRODUCT by my PRODUCT_ID, named 'product'. */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ID")
    protected Product product;

    /**
     * PRODUCT by my PRODUCT_ID, named 'product'.
     * @return The entity of foreign property 'product'. (NullAllowed: If the foreign key does not have 'NotNull' constraint, please check null.)
     */
    public Product getProduct() {
        return product;
    }

    /**
     * PRODUCT by my PRODUCT_ID, named 'product'.
     * @param product The entity of foreign property 'product'. (NullAllowed)
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
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
        if (other == null || !(other instanceof BsPurchase)) { return false; }
        BsPurchase otherEntity = (BsPurchase)other;
        if (!helpComparingValue(getPurchaseId(), otherEntity.getPurchaseId())) { return false; }
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
        if (getPurchaseId() != null) { result = (31*result) + getPurchaseId().hashCode(); }
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
        if (member != null)
        { sb.append(l).append(xbRDS(member, "member")); }
        if (product != null)
        { sb.append(l).append(xbRDS(product, "product")); }
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
        sb.append(c).append(purchaseId);
        sb.append(c).append(purchaseDatetime);
        sb.append(c).append(purchaseCount);
        sb.append(c).append(purchasePrice);
        sb.append(c).append(paymentCompleteFlg);
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
        if (member != null) { sb.append(c).append("member"); }
        if (product != null) { sb.append(c).append("product"); }
        if (sb.length() > 0) { sb.delete(0, c.length()).insert(0, "(").append(")"); }
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * PURCHASE_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * @return The value of the column 'PURCHASE_ID'. (NullAllowed)
     */
    public Long getPurchaseId() {
        return purchaseId;
    }

    /**
     * PURCHASE_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * @param purchaseId The value of the column 'PURCHASE_ID'. (NullAllowed)
     */
    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    /**
     * PURCHASE_DATETIME: {+UQ, NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'PURCHASE_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getPurchaseDatetime() {
        return purchaseDatetime;
    }

    /**
     * PURCHASE_DATETIME: {+UQ, NotNull, TIMESTAMP(23, 10)} <br />
     * @param purchaseDatetime The value of the column 'PURCHASE_DATETIME'. (NullAllowed)
     */
    public void setPurchaseDatetime(java.sql.Timestamp purchaseDatetime) {
        this.purchaseDatetime = purchaseDatetime;
    }

    /**
     * PURCHASE_COUNT: {NotNull, INTEGER(10)} <br />
     * @return The value of the column 'PURCHASE_COUNT'. (NullAllowed)
     */
    public Integer getPurchaseCount() {
        return purchaseCount;
    }

    /**
     * PURCHASE_COUNT: {NotNull, INTEGER(10)} <br />
     * @param purchaseCount The value of the column 'PURCHASE_COUNT'. (NullAllowed)
     */
    public void setPurchaseCount(Integer purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    /**
     * PURCHASE_PRICE: {NotNull, INTEGER(10)} <br />
     * @return The value of the column 'PURCHASE_PRICE'. (NullAllowed)
     */
    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * PURCHASE_PRICE: {NotNull, INTEGER(10)} <br />
     * @param purchasePrice The value of the column 'PURCHASE_PRICE'. (NullAllowed)
     */
    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * PAYMENT_COMPLETE_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * @return The value of the column 'PAYMENT_COMPLETE_FLG'. (NullAllowed)
     */
    public Integer getPaymentCompleteFlg() {
        return paymentCompleteFlg;
    }

    /**
     * PAYMENT_COMPLETE_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * @param paymentCompleteFlg The value of the column 'PAYMENT_COMPLETE_FLG'. (NullAllowed)
     */
    public void setPaymentCompleteFlg(Integer paymentCompleteFlg) {
        this.paymentCompleteFlg = paymentCompleteFlg;
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
