package com.example.dbflute.s2jdbc.entity.bs.pmbean;

/**
 * The parameter-bean of UnpaidSummaryMemberPmb.
 * @author DBFlute(AutoGenerator)
 */
public class BsUnpaidSummaryMemberPmb {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * memberId <br />
     */
    public Integer memberId;

    /**
     * memberName <br />
     */
    public String memberName;

    /**
     * memberStatusCode:cls(MemberStatus) <br />
     */
    public String memberStatusCode;

    /**
     * unpaidMemberOnly <br />
     */
    public boolean unpaidMemberOnly;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsUnpaidSummaryMemberPmb() {
    }
    
    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * @return The view of properties. (NotNull)
     */
    @Override
    public String toString() {
        final String delimiter = ",";
        final StringBuilder sb = new StringBuilder();
        sb.append(delimiter).append(memberId);
        sb.append(delimiter).append(memberName);
        sb.append(delimiter).append(memberStatusCode);
        sb.append(delimiter).append(unpaidMemberOnly);
        sb.delete(0, delimiter.length());
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
