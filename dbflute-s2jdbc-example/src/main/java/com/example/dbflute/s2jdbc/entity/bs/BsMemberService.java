package com.example.dbflute.s2jdbc.entity.bs;

import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.s2jdbc.entity.*;

/**
 * The entity of (会員サービス)MEMBER_SERVICE as TABLE. <br />
 * 会員のサービス情報（ポイントサービスなど）。<br />
 * ExampleDBとして、あえて統一性を崩してユニーク制約経由の one-to-one を表現している。
 * <pre>
 * [primary-key]
 *     MEMBER_SERVICE_ID
 * 
 * [column]
 *     MEMBER_SERVICE_ID, MEMBER_ID, SERVICE_POINT_COUNT, SERVICE_RANK_CODE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_SERVICE_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER, SERVICE_RANK
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, serviceRank
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsMemberService implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * (会員サービスID)MEMBER_SERVICE_ID: {PK, ID, NotNull, INTEGER(10)} <br />
     * 独立した主キーとなるが、実質的に会員IDとは one-to-one である。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer memberServiceId;

    /**
     * (会員ID)MEMBER_ID: {UQ, IX, NotNull, INTEGER(10), FK to MEMBER} <br />
     * 会員を参照するID。ユニークなので、会員とは one-to-one の関係に。
     */
    public Integer memberId;

    /**
     * (サービスポイント数)SERVICE_POINT_COUNT: {IX, NotNull, INTEGER(10)} <br />
     * 会員が現在利用できるサービスポイントの数。<br />
     * 基本的に、購入時には増えてポイントを使ったら減る。
     */
    public Integer servicePointCount;

    /**
     * (サービスランクコード)SERVICE_RANK_CODE: {IX, NotNull, CHAR(3), FK to SERVICE_RANK} <br />
     * サービスランクを参照するコード。<br />
     * どんなランクがあるのかドキドキですね。
     */
    public String serviceRankCode;

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
     * (サービスランク)SERVICE_RANK by my SERVICE_RANK_CODE, named 'serviceRank'.
     */
    @ManyToOne
    @JoinColumn(name="SERVICE_RANK_CODE")
    public ServiceRank serviceRank;

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
        if (other == null || !(other instanceof BsMemberService)) { return false; }
        BsMemberService otherEntity = (BsMemberService)other;
        if (!helpComparingValue(memberServiceId, otherEntity.memberServiceId)) { return false; }
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
        if (memberServiceId != null) { result = (31*result) + memberServiceId.hashCode(); }
        return result;
    }

    /**
     * @return The view string of all columns. (NotNull)
     */
    public String toString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(memberServiceId);
        sb.append(delimiter).append(memberId);
        sb.append(delimiter).append(servicePointCount);
        sb.append(delimiter).append(serviceRankCode);
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
