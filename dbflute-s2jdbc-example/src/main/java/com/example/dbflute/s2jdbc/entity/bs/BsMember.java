package com.example.dbflute.s2jdbc.entity.bs;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.s2jdbc.entity.*;

/**
 * The entity of (会員)MEMBER as TABLE. <br />
 * 会員登録時にデータが登録される。基本的に物理削除はなく、退会したらステータスが退会会員になる。ライフサイクルやカテゴリの違う会員それぞれの詳細情報は、別途 one-to-one のテーブルに。
 * <pre>
 * [primary-key]
 *     MEMBER_ID
 * 
 * [column]
 *     MEMBER_ID, MEMBER_NAME, MEMBER_ACCOUNT, MEMBER_STATUS_CODE, FORMALIZED_DATETIME, BIRTHDATE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER_STATUS, MEMBER_SECURITY(AsOne), MEMBER_SERVICE(AsOne), MEMBER_WITHDRAWAL(AsOne)
 * 
 * [referrer-table]
 *     MEMBER_ADDRESS, MEMBER_LOGIN, PURCHASE, MEMBER_SECURITY, MEMBER_SERVICE, MEMBER_WITHDRAWAL
 * 
 * [foreign-property]
 *     memberStatus, memberSecurityAsOne, memberServiceAsOne, memberWithdrawalAsOne
 * 
 * [referrer-property]
 *     memberAddressList, memberLoginList, purchaseList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsMember implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10)} <br />
     * 会員を識別するID。連番として自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMS次第。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer memberId;

    /**
     * (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)} <br />
     * 会員のフルネームの名称。<br />
     * 苗字と名前を分けて管理することも多いが、ここでは Example なので単純にひとまとめ。
     */
    public String memberName;

    /**
     * (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)} <br />
     * 会員がログイン時に利用するアカウントNO。<br />
     * 昨今、メールアドレスをログインIDとすることが多いので、あまり見かけなくないかも。
     */
    public String memberAccount;

    /**
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS} <br />
     * 会員ステータスを参照するコード。<br />
     * ステータスが変わるたびに、このカラムが更新される。
     */
    public String memberStatusCode;

    /**
     * (正式会員日時)FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)} <br />
     * 会員が正式に確定した日時。<br />
     * 一度確定したら更新されない。
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.sql.Timestamp formalizedDatetime;

    /**
     * (生年月日)BIRTHDATE: {DATE(8)} <br />
     * 必須項目ではないので、このデータがない会員もいる。
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    public java.util.Date birthdate;

    /**
     * (登録日時)REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * レコードが登録された日時。<br />
     * 会員が登録された日時とほぼ等しいが、そういった業務的な役割を兼務させるのはあまり推奨されない。<br />
     * どのテーブルでも同じなので、共通カラムの説明はこのテーブルでしか書かない。
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.sql.Timestamp registerDatetime;

    /**
     * (登録ユーザ)REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * レコードを登録したユーザ。<br />
     * 会員テーブルであれば当然、会員自身であるはずだが、他のテーブルの場合では管理画面から運用者による登録など考えられるので、しっかり保持しておく。
     */
    public String registerUser;

    /**
     * (更新日時)UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * レコードが（最後に）更新された日時。<br />
     * 業務的な利用はあまり推奨されないと別項目で説明したが、このカラムはソートの要素としてよく利用される。
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.sql.Timestamp updateDatetime;

    /**
     * (更新ユーザ)UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * レコードを更新したユーザ。<br />
     * システムは誰が何をしたのかちゃんと覚えている。
     */
    public String updateUser;

    /**
     * (バージョンNO)VERSION_NO: {NotNull, BIGINT(19)} <br />
     * レコードのバージョンを示すNO。<br />
     * 更新回数と等しく、主に排他制御のために利用される。
     */
    @Version
    public Long versionNo;

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    /**
     * (会員ステータス)MEMBER_STATUS by my MEMBER_STATUS_CODE, named 'memberStatus'.
     */
    @ManyToOne
    @JoinColumn(name="MEMBER_STATUS_CODE")
    public MemberStatus memberStatus;

    /**
     * (会員セキュリティ情報)MEMBER_SECURITY by MEMBER_ID, named 'memberSecurityAsOne'.
     */
    @OneToOne(mappedBy = "member")
    public MemberSecurity memberSecurity;

    /**
     * (会員サービス)MEMBER_SERVICE by MEMBER_ID, named 'memberServiceAsOne'.
     */
    @OneToOne(mappedBy = "member")
    public MemberService memberService;

    /**
     * (会員退会情報)MEMBER_WITHDRAWAL by MEMBER_ID, named 'memberWithdrawalAsOne'.
     */
    @OneToOne(mappedBy = "member")
    public MemberWithdrawal memberWithdrawal;

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    /**
     * (会員住所情報)MEMBER_ADDRESS by MEMBER_ID, named 'memberAddressList'.
     */
    @OneToMany(mappedBy = "member")
    public List<MemberAddress> memberAddressList;

    /**
     * (会員ログイン)MEMBER_LOGIN by MEMBER_ID, named 'memberLoginList'.
     */
    @OneToMany(mappedBy = "member")
    public List<MemberLogin> memberLoginList;

    /**
     * (購入)PURCHASE by MEMBER_ID, named 'purchaseList'.
     */
    @OneToMany(mappedBy = "member")
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
        if (other == null || !(other instanceof BsMember)) { return false; }
        BsMember otherEntity = (BsMember)other;
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
        sb.append(delimiter).append(memberName);
        sb.append(delimiter).append(memberAccount);
        sb.append(delimiter).append(memberStatusCode);
        sb.append(delimiter).append(formalizedDatetime);
        sb.append(delimiter).append(birthdate);
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
