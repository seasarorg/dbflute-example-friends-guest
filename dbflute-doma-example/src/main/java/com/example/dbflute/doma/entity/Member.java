package com.example.dbflute.doma.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
public class Member {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** (会員ID)MEMBER_ID: {PK : ID : NotNull : INTEGER(10) : FK to MEMBER_ADDRESS} */
    protected Integer memberId;

    /** (会員名称)MEMBER_NAME: {NotNull : VARCHAR(200)} */
    protected String memberName;

    /** (会員アカウント)MEMBER_ACCOUNT: {UQ : NotNull : VARCHAR(50)} */
    protected String memberAccount;

    /** (会員ステータスコード)MEMBER_STATUS_CODE: {NotNull : CHAR(3) : FK to MEMBER_STATUS} */
    protected String memberStatusCode;

    /** (正式会員日時)FORMALIZED_DATETIME: {TIMESTAMP(23, 10)} */
    protected java.sql.Timestamp formalizedDatetime;

    /** (生年月日)BIRTHDATE: {DATE(8)} */
    protected java.sql.Date birthdate;

    /** REGISTER_DATETIME: {NotNull : TIMESTAMP(23, 10)} */
    protected java.sql.Timestamp registerDatetime;

    /** REGISTER_USER: {NotNull : VARCHAR(200)} */
    protected String registerUser;

    /** REGISTER_PROCESS: {NotNull : VARCHAR(200)} */
    protected String registerProcess;

    /** UPDATE_DATETIME: {NotNull : TIMESTAMP(23, 10)} */
    protected java.sql.Timestamp updateDatetime;

    /** UPDATE_USER: {NotNull : VARCHAR(200)} */
    protected String updateUser;

    /** UPDATE_PROCESS: {NotNull : VARCHAR(200)} */
    protected String updateProcess;

    /** VERSION_NO: {NotNull : BIGINT(19)} */
    protected Long versionNo;

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * If the primary-key of the other is same as this one, returns true.
     * @param other Other entity.
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Member)) {
            return false;
        }
        Member otherEntity = (Member) other;
        if (!helpComparingValue(getMemberId(), otherEntity.getMemberId())) {
            return false;
        }
        return true;
    }

    protected boolean helpComparingValue(Object value1, Object value2) {
        if (value1 == null && value2 == null) {
            return true;
        }
        return value1 != null && value2 != null && value1.equals(value2);
    }

    /**
     * Calculates hash-code from primary-key.
     * @return Hash-code from primary-key.
     */
    public int hashCode() {
        int result = 17;
        if (getMemberId() != null) {
            result = (31 * result) + getMemberId().hashCode();
        }
        return result;
    }

    /**
     * @return The display string of all columns and relation existences. (NotNull)
     */
    public String toString() {
        return buildDisplayString(getClass().getSimpleName(), true);
    }

    /**
     * @param name The name for display. (Nullable: If it's null, it does not have a name)
     * @param column Does it contains column values or not?
     * @param relation Does it contains relation existences or not?
     * @return The display string for this entity. (NotNull)
     */
    public String buildDisplayString(String name, boolean column) {
        StringBuilder sb = new StringBuilder();
        if (name != null) {
            sb.append(name).append(column ? ":" : "");
        }
        if (column) {
            sb.append(xbuildColumnString());
        }
        sb.append("@").append(Integer.toHexString(hashCode()));
        return sb.toString();
    }

    private String xbuildColumnString() {
        String c = ",";
        StringBuilder sb = new StringBuilder();
        sb.append(c).append(getMemberId());
        sb.append(c).append(getMemberName());
        sb.append(c).append(getMemberAccount());
        sb.append(c).append(getMemberStatusCode());
        sb.append(c).append(getFormalizedDatetime());
        sb.append(c).append(getBirthdate());
        sb.append(c).append(getRegisterDatetime());
        sb.append(c).append(getRegisterUser());
        sb.append(c).append(getRegisterProcess());
        sb.append(c).append(getUpdateDatetime());
        sb.append(c).append(getUpdateUser());
        sb.append(c).append(getUpdateProcess());
        sb.append(c).append(getVersionNo());
        if (sb.length() > 0) {
            sb.delete(0, c.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (会員ID)MEMBER_ID: {PK : ID : NotNull : INTEGER(10) : FK to MEMBER_ADDRESS} <br />
     * 連番
     * @return The value of the column 'MEMBER_ID'. (Nullable)
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * [set] (会員ID)MEMBER_ID: {PK : ID : NotNull : INTEGER(10) : FK to MEMBER_ADDRESS} <br />
     * 連番
     * @param memberId The value of the column 'MEMBER_ID'. (Nullable)
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * [get] (会員名称)MEMBER_NAME: {NotNull : VARCHAR(200)} <br />
     * 会員の表示用の名称(姓名)
     * @return The value of the column 'MEMBER_NAME'. (Nullable)
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * [set] (会員名称)MEMBER_NAME: {NotNull : VARCHAR(200)} <br />
     * 会員の表示用の名称(姓名)
     * @param memberName The value of the column 'MEMBER_NAME'. (Nullable)
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * [get] (会員アカウント)MEMBER_ACCOUNT: {UQ : NotNull : VARCHAR(50)} <br />
     * 会員のログイン用のアカウント
     * @return The value of the column 'MEMBER_ACCOUNT'. (Nullable)
     */
    public String getMemberAccount() {
        return memberAccount;
    }

    /**
     * [set] (会員アカウント)MEMBER_ACCOUNT: {UQ : NotNull : VARCHAR(50)} <br />
     * 会員のログイン用のアカウント
     * @param memberAccount The value of the column 'MEMBER_ACCOUNT'. (Nullable)
     */
    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    /**
     * [get] (会員ステータスコード)MEMBER_STATUS_CODE: {NotNull : CHAR(3) : FK to MEMBER_STATUS} <br />
     * @return The value of the column 'MEMBER_STATUS_CODE'. (Nullable)
     */
    public String getMemberStatusCode() {
        return memberStatusCode;
    }

    /**
     * [set] (会員ステータスコード)MEMBER_STATUS_CODE: {NotNull : CHAR(3) : FK to MEMBER_STATUS} <br />
     * @param memberStatusCode The value of the column 'MEMBER_STATUS_CODE'. (Nullable)
     */
    public void setMemberStatusCode(String memberStatusCode) {
        this.memberStatusCode = memberStatusCode;
    }

    /**
     * [get] (正式会員日時)FORMALIZED_DATETIME: {TIMESTAMP(23, 10)} <br />
     * 正式会員になる前はデータなし
     * @return The value of the column 'FORMALIZED_DATETIME'. (Nullable)
     */
    public java.sql.Timestamp getFormalizedDatetime() {
        return formalizedDatetime;
    }

    /**
     * [set] (正式会員日時)FORMALIZED_DATETIME: {TIMESTAMP(23, 10)} <br />
     * 正式会員になる前はデータなし
     * @param formalizedDatetime The value of the column 'FORMALIZED_DATETIME'. (Nullable)
     */
    public void setFormalizedDatetime(java.sql.Timestamp formalizedDatetime) {
        this.formalizedDatetime = formalizedDatetime;
    }

    /**
     * [get] (生年月日)BIRTHDATE: {DATE(8)} <br />
     * 不明な場合はデータなし
     * @return The value of the column 'BIRTHDATE'. (Nullable)
     */
    public java.util.Date getBirthdate() {
        return birthdate;
    }

    /**
     * [set] (生年月日)BIRTHDATE: {DATE(8)} <br />
     * 不明な場合はデータなし
     * @param birthdate The value of the column 'BIRTHDATE'. (Nullable)
     */
    public void setBirthdate(java.sql.Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * [get] REGISTER_DATETIME: {NotNull : TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'REGISTER_DATETIME'. (Nullable)
     */
    public java.sql.Timestamp getRegisterDatetime() {
        return registerDatetime;
    }

    /**
     * [set] REGISTER_DATETIME: {NotNull : TIMESTAMP(23, 10)} <br />
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (Nullable)
     */
    public void setRegisterDatetime(java.sql.Timestamp registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    /**
     * [get] REGISTER_USER: {NotNull : VARCHAR(200)} <br />
     * @return The value of the column 'REGISTER_USER'. (Nullable)
     */
    public String getRegisterUser() {
        return registerUser;
    }

    /**
     * [set] REGISTER_USER: {NotNull : VARCHAR(200)} <br />
     * @param registerUser The value of the column 'REGISTER_USER'. (Nullable)
     */
    public void setRegisterUser(String registerUser) {
        this.registerUser = registerUser;
    }

    /**
     * [get] REGISTER_PROCESS: {NotNull : VARCHAR(200)} <br />
     * @return The value of the column 'REGISTER_PROCESS'. (Nullable)
     */
    public String getRegisterProcess() {
        return registerProcess;
    }

    /**
     * [set] REGISTER_PROCESS: {NotNull : VARCHAR(200)} <br />
     * @param registerProcess The value of the column 'REGISTER_PROCESS'. (Nullable)
     */
    public void setRegisterProcess(String registerProcess) {
        this.registerProcess = registerProcess;
    }

    /**
     * [get] UPDATE_DATETIME: {NotNull : TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'UPDATE_DATETIME'. (Nullable)
     */
    public java.sql.Timestamp getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * [set] UPDATE_DATETIME: {NotNull : TIMESTAMP(23, 10)} <br />
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (Nullable)
     */
    public void setUpdateDatetime(java.sql.Timestamp updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    /**
     * [get] UPDATE_USER: {NotNull : VARCHAR(200)} <br />
     * @return The value of the column 'UPDATE_USER'. (Nullable)
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * [set] UPDATE_USER: {NotNull : VARCHAR(200)} <br />
     * @param updateUser The value of the column 'UPDATE_USER'. (Nullable)
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * [get] UPDATE_PROCESS: {NotNull : VARCHAR(200)} <br />
     * @return The value of the column 'UPDATE_PROCESS'. (Nullable)
     */
    public String getUpdateProcess() {
        return updateProcess;
    }

    /**
     * [set] UPDATE_PROCESS: {NotNull : VARCHAR(200)} <br />
     * @param updateProcess The value of the column 'UPDATE_PROCESS'. (Nullable)
     */
    public void setUpdateProcess(String updateProcess) {
        this.updateProcess = updateProcess;
    }

    /**
     * [get] VERSION_NO: {NotNull : BIGINT(19)} <br />
     * @return The value of the column 'VERSION_NO'. (Nullable)
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     * [set] VERSION_NO: {NotNull : BIGINT(19)} <br />
     * @param versionNo The value of the column 'VERSION_NO'. (Nullable)
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }
}
