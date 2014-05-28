package com.example.dbflute.s2jdbc.entity.bs;

import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.s2jdbc.entity.*;

/**
 * The entity of (会員住所情報)MEMBER_ADDRESS as TABLE. <br />
 * 会員の住所に関する情報で、同時に有効期間ごとに履歴管理されている。<br />
 * 会員を基点に考えた場合、構造的にはone-to-many だが、業務的な定型条件でone-to-one になる。このような構造を「業務的one-to-one」と呼ぶ。<br />
 * 有効期間は隙間なく埋められるが、ここでは住所情報のない会員も存在し、厳密には(業務的な) "1 : 0...1" である。
 * <pre>
 * [primary-key]
 *     MEMBER_ADDRESS_ID
 * 
 * [column]
 *     MEMBER_ADDRESS_ID, MEMBER_ID, VALID_BEGIN_DATE, VALID_END_DATE, ADDRESS, REGION_ID, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_ADDRESS_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER, REGION
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, region
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsMemberAddress implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * (会員住所ID)MEMBER_ADDRESS_ID: {PK, ID, NotNull, INTEGER(10)} <br />
     * 会員住所を識別するID。<br />
     * 履歴分も含むテーブルなので、これ自体はFKではない。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer memberAddressId;

    /**
     * (会員ID)MEMBER_ID: {UQ+, IX, NotNull, INTEGER(10), FK to MEMBER} <br />
     * 会員を参照するID。<br />
     * 履歴分を含むため、これだけではユニークにはならない。<br />
     * 有効開始日と合わせて複合ユニーク制約となるが、<br />
     * 厳密には完全な制約にはなっていない。<br />
     * 有効期間の概念はRDBでは表現しきれないのである。
     */
    public Integer memberId;

    /**
     * (有効開始日)VALID_BEGIN_DATE: {+UQ, NotNull, DATE(8)} <br />
     * 一つの有効期間の開始を示す日付。<br />
     * 前の有効終了日の次の日の値が格納される。
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    public java.util.Date validBeginDate;

    /**
     * (有効終了日)VALID_END_DATE: {NotNull, DATE(8)} <br />
     * 有効期間の終了日。<br />
     * 次の有効開始日の一日前の値が格納される。<br />
     * ただし、次の有効期間がない場合は 9999/12/31 となる。
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    public java.util.Date validEndDate;

    /**
     * (住所)ADDRESS: {NotNull, VARCHAR(200)} <br />
     * まるごと住所
     */
    public String address;

    /**
     * (地域ID)REGION_ID: {IX, NotNull, INTEGER(10), FK to REGION} <br />
     * 地域を参照するID。<br />
     * ここでは特に住所の内容と連動しているわけではない。<br />
     * （業務的one-to-oneの親テーブルの表現したかっ...）
     */
    public Integer regionId;

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
     * (地域)REGION by my REGION_ID, named 'region'.
     */
    @ManyToOne
    @JoinColumn(name="REGION_ID")
    public Region region;

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
        if (other == null || !(other instanceof BsMemberAddress)) { return false; }
        BsMemberAddress otherEntity = (BsMemberAddress)other;
        if (!helpComparingValue(memberAddressId, otherEntity.memberAddressId)) { return false; }
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
        if (memberAddressId != null) { result = (31*result) + memberAddressId.hashCode(); }
        return result;
    }

    /**
     * @return The view string of all columns. (NotNull)
     */
    public String toString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(memberAddressId);
        sb.append(delimiter).append(memberId);
        sb.append(delimiter).append(validBeginDate);
        sb.append(delimiter).append(validEndDate);
        sb.append(delimiter).append(address);
        sb.append(delimiter).append(regionId);
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
