package com.example.dbflute.s2jdbc.entity.bs;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.s2jdbc.entity.*;

/**
 * The entity of (会員ステータス)MEMBER_STATUS as TABLE. <br />
 * 会員のステータスを示す固定的なマスタテーブル。<br />
 * 業務で増えることはなく、増減するときは実装もともなうレベルの業務変更と考えられる。<br />
 * <br />
 * こういった固定的なマスタテーブルには、更新日時などの共通カラムは定義していないが、業務上そういった情報を管理する必要性が低いという理由に加え、ExampleDBとして共通カラムでER図が埋め尽くされてしまい見づらくなるという<br />
 * ところで割り切っている。実業務では統一的に定義することもある。
 * <pre>
 * [primary-key]
 *     MEMBER_STATUS_CODE
 * 
 * [column]
 *     MEMBER_STATUS_CODE, MEMBER_STATUS_NAME, DESCRIPTION, DISPLAY_ORDER
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
 *     MEMBER, MEMBER_LOGIN
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     memberList, memberLoginList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsMemberStatus implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3)} <br />
     * 会員ステータスを識別するコード。<br />
     * 固定的なデータなので、連番とか番号にはせず、<br />
     * データを直接見たときも人が直感的にわかるように、<br />
     * このような３桁のコード形式にしている。
     */
    @Id
    public String memberStatusCode;

    /**
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)} <br />
     */
    public String memberStatusName;

    /**
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)} <br />
     * 会員ステータスそれぞれの説明。<br />
     * 気の利いた説明があるとディベロッパーがとても助かる。
     */
    public String description;

    /**
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)} <br />
     * UI上のステータスの表示順を示すNO。<br />
     * 並べるときは、このカラムに対して昇順のソート条件にする。
     */
    public Integer displayOrder;

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    /**
     * (会員)MEMBER by MEMBER_STATUS_CODE, named 'memberList'.
     */
    @OneToMany(mappedBy = "memberStatus")
    public List<Member> memberList;

    /**
     * (会員ログイン)MEMBER_LOGIN by LOGIN_MEMBER_STATUS_CODE, named 'memberLoginList'.
     */
    @OneToMany(mappedBy = "memberStatus")
    public List<MemberLogin> memberLoginList;

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * If the primary-key of the other is same as this one, returns true.
     * @param other Other entity.
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsMemberStatus)) { return false; }
        BsMemberStatus otherEntity = (BsMemberStatus)other;
        if (!helpComparingValue(memberStatusCode, otherEntity.memberStatusCode)) { return false; }
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
        if (memberStatusCode != null) { result = (31*result) + memberStatusCode.hashCode(); }
        return result;
    }

    /**
     * @return The view string of all columns. (NotNull)
     */
    public String toString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(memberStatusCode);
        sb.append(delimiter).append(memberStatusName);
        sb.append(delimiter).append(description);
        sb.append(delimiter).append(displayOrder);
        if (sb.length() > 0) { sb.delete(0, delimiter.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
