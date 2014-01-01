package com.example.dbflute.s2jdbc.entity.bs.pmbean;

/**
 * The parameter-bean of PurchaseSummaryMemberPmb.
 * @author DBFlute(AutoGenerator)
 */
public class BsPurchaseSummaryMemberPmb {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * memberStatusCode:cls(MemberStatus) <br />
     */
    public String memberStatusCode;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsPurchaseSummaryMemberPmb() {
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
        sb.append(delimiter).append(memberStatusCode);
        sb.delete(0, delimiter.length());
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
