package com.example.dbflute.s2jdbc.entity.bs;

import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.s2jdbc.entity.*;

/**
 * The entity of (会員退会情報)MEMBER_WITHDRAWAL as TABLE. <br />
 * 退会会員の退会に関する詳細な情報。<br />
 * 退会会員のみデータが存在する。（"1 : 0...1" のパターンの one-to-one）<br />
 * 共通カラムがあってバージョンNOがないパターン。基本的に更新が入ることはないが、登録ユーザを保持したいのと、重要なデータなので更新系の情報も。
 * <pre>
 * [primary-key]
 *     MEMBER_ID
 * 
 * [column]
 *     MEMBER_ID, WITHDRAWAL_REASON_CODE, WITHDRAWAL_REASON_INPUT_TEXT, WITHDRAWAL_DATETIME, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER, WITHDRAWAL_REASON
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, withdrawalReason
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsMemberWithdrawal implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * MEMBER_ID: {PK, NotNull, INTEGER(10), FK to MEMBER} <br />
     */
    @Id
    public Integer memberId;

    /**
     * (退会理由コード)WITHDRAWAL_REASON_CODE: {IX, CHAR(3), FK to WITHDRAWAL_REASON} <br />
     * 退会した定型理由を参照するコード。<br />
     * 何も言わずに退会する会員もいるので必須項目ではない。
     */
    public String withdrawalReasonCode;

    /**
     * (退会理由入力テキスト)WITHDRAWAL_REASON_INPUT_TEXT: {CLOB(2147483647)} <br />
     * 会員がフリーテキストで入力できる退会理由。<br />
     * もう言いたいこと言ってもらう感じ。<br />
     * サイト運営側としては真摯に受け止めて改善していきたい。
     */
    public String withdrawalReasonInputText;

    /**
     * (退会日時)WITHDRAWAL_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * 退会した瞬間の日時。<br />
     * 正式会員日時と違い、こっちはone-to-oneの別テーブルで。
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.sql.Timestamp withdrawalDatetime;

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
     * (退会理由)WITHDRAWAL_REASON by my WITHDRAWAL_REASON_CODE, named 'withdrawalReason'.
     */
    @ManyToOne
    @JoinColumn(name="WITHDRAWAL_REASON_CODE")
    public WithdrawalReason withdrawalReason;

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
        if (other == null || !(other instanceof BsMemberWithdrawal)) { return false; }
        BsMemberWithdrawal otherEntity = (BsMemberWithdrawal)other;
        if (!helpComparingValue(memberId, otherEntity.memberId)) { return false; }
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
        if (memberId != null) { result = (31*result) + memberId.hashCode(); }
        return result;
    }

    /**
     * @return The view string of all columns. (NotNull)
     */
    public String toString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(memberId);
        sb.append(delimiter).append(withdrawalReasonCode);
        sb.append(delimiter).append(withdrawalReasonInputText);
        sb.append(delimiter).append(withdrawalDatetime);
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
