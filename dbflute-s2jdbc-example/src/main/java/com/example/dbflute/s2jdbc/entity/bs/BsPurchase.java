package com.example.dbflute.s2jdbc.entity.bs;

import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.s2jdbc.entity.*;

/**
 * The entity of (購入)PURCHASE as TABLE. <br />
 * 一つの商品に対する購入を表現する。<br />
 * 実業務であれば購入詳細というテーブルを作り、「購入という行為」と「その中身（詳細）」を違う粒度のデータとしてそれぞれ管理するのが一般的と言えるでしょう。というか、注文とか請求とかそういうことを考え始めたらもっと複雑になるはずですが、ExampleDBということで割り切っています。
 * <pre>
 * [primary-key]
 *     PURCHASE_ID
 * 
 * [column]
 *     PURCHASE_ID, MEMBER_ID, PRODUCT_ID, PURCHASE_DATETIME, PURCHASE_COUNT, PURCHASE_PRICE, PAYMENT_COMPLETE_FLG, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
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
public abstract class BsPurchase implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * PURCHASE_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long purchaseId;

    /**
     * (会員ID)MEMBER_ID: {UQ, IX, NotNull, INTEGER(10), FK to MEMBER} <br />
     * 会員を参照するID。<br />
     * 購入を識別する自然キー（複合ユニーク制約）の筆頭要素。
     */
    public Integer memberId;

    /**
     * (商品ID)PRODUCT_ID: {UQ+, IX, NotNull, INTEGER(10), FK to PRODUCT} <br />
     * 商品を参照するID。
     */
    public Integer productId;

    /**
     * (購入日時)PURCHASE_DATETIME: {UQ+, IX, NotNull, TIMESTAMP(23, 10)} <br />
     * 購入した瞬間の日時。
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.sql.Timestamp purchaseDatetime;

    /**
     * (購入数量)PURCHASE_COUNT: {NotNull, INTEGER(10)} <br />
     * 購入した商品の（一回の購入における）数量。
     */
    public Integer purchaseCount;

    /**
     * (購入価格)PURCHASE_PRICE: {IX, NotNull, INTEGER(10)} <br />
     * 購入によって実際に会員が支払った（支払う予定の）価格。<br />
     * 基本は商品の定価に購入数量を掛けたものになるが、<br />
     * ポイント利用や割引があったりと必ずしもそうはならない。
     */
    public Integer purchasePrice;

    /**
     * (支払完了フラグ)PAYMENT_COMPLETE_FLG: {NotNull, INTEGER(10)} <br />
     * この購入に関しての支払いが完了しているか否か。
     */
    public Integer paymentCompleteFlg;

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
     * (会員)MEMBER by my MEMBER_ID, named 'member'.
     */
    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    public Member member;

    /**
     * (商品)PRODUCT by my PRODUCT_ID, named 'product'.
     */
    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    public Product product;

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
        if (other == null || !(other instanceof BsPurchase)) { return false; }
        BsPurchase otherEntity = (BsPurchase)other;
        if (!helpComparingValue(purchaseId, otherEntity.purchaseId)) { return false; }
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
        if (purchaseId != null) { result = (31*result) + purchaseId.hashCode(); }
        return result;
    }

    /**
     * @return The view string of all columns. (NotNull)
     */
    public String toString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(purchaseId);
        sb.append(delimiter).append(memberId);
        sb.append(delimiter).append(productId);
        sb.append(delimiter).append(purchaseDatetime);
        sb.append(delimiter).append(purchaseCount);
        sb.append(delimiter).append(purchasePrice);
        sb.append(delimiter).append(paymentCompleteFlg);
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
