package com.example.dbflute.s2jdbc.entity.bs;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import com.example.dbflute.s2jdbc.entity.*;

/**
 * The entity of (サービスランク)SERVICE_RANK as TABLE. <br />
 * 会員のサービスレベルを表現するランク。<br />
 * （ゴールドとかプラチナとか）
 * <pre>
 * [primary-key]
 *     SERVICE_RANK_CODE
 * 
 * [column]
 *     SERVICE_RANK_CODE, SERVICE_RANK_NAME, SERVICE_POINT_INCIDENCE, NEW_ACCEPTABLE_FLG, DESCRIPTION, DISPLAY_ORDER
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
 *     MEMBER_SERVICE
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     memberServiceList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@MappedSuperclass
public abstract class BsServiceRank implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * (サービスランクコード)SERVICE_RANK_CODE: {PK, NotNull, CHAR(3)} <br />
     * サービスランクを識別するコード。
     */
    @Id
    public String serviceRankCode;

    /**
     * (サービスランク名称)SERVICE_RANK_NAME: {NotNull, VARCHAR(50)} <br />
     * サービスランクの名称。<br />
     * （ゴールドとかプラチナとか基本的には威厳のある名前）
     */
    public String serviceRankName;

    /**
     * (サービスポイント発生率)SERVICE_POINT_INCIDENCE: {NotNull, DECIMAL(5, 3)} <br />
     * 購入ごとのサービスポイントの発生率。<br />
     * 購入価格にこの値をかけた数が発生ポイント。<br />
     * ExampleDBとして数少ない貴重な小数点ありのカラム。
     */
    public java.math.BigDecimal servicePointIncidence;

    /**
     * (新規受け入れ可能フラグ)NEW_ACCEPTABLE_FLG: {NotNull, INTEGER(10)} <br />
     * このランクへの新規受け入れができるかどうか。
     */
    public Integer newAcceptableFlg;

    /**
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)} <br />
     * ランクに関する業務的な説明。
     */
    public String description;

    /**
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)} <br />
     * UI上の表示順を表現する番号。
     */
    public Integer displayOrder;

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    /**
     * (会員サービス)MEMBER_SERVICE by SERVICE_RANK_CODE, named 'memberServiceList'.
     */
    @OneToMany(mappedBy = "serviceRank")
    public List<MemberService> memberServiceList;

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * If the primary-key of the other is same as this one, returns true.
     * @param other Other entity.
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsServiceRank)) { return false; }
        BsServiceRank otherEntity = (BsServiceRank)other;
        if (!helpComparingValue(serviceRankCode, otherEntity.serviceRankCode)) { return false; }
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
        if (serviceRankCode != null) { result = (31*result) + serviceRankCode.hashCode(); }
        return result;
    }

    /**
     * @return The view string of all columns. (NotNull)
     */
    public String toString() {
        String delimiter = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(serviceRankCode);
        sb.append(delimiter).append(serviceRankName);
        sb.append(delimiter).append(servicePointIncidence);
        sb.append(delimiter).append(newAcceptableFlg);
        sb.append(delimiter).append(description);
        sb.append(delimiter).append(displayOrder);
        if (sb.length() > 0) { sb.delete(0, delimiter.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
