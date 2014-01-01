package com.example.dbflute.s2jdbc.entity.bs.pmbean;

/**
 * The parameter-bean of SimpleMemberPmb.
 * @author DBFlute(AutoGenerator)
 */
public class BsSimpleMemberPmb {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * memberId <br />
     * this is parameter comment of MEMBER_ID
     */
    public Integer memberId;

    /**
     * memberName <br />
     * this is parameter comment of MEMBER_NAME
     */
    public String memberName;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsSimpleMemberPmb() {
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
        sb.delete(0, delimiter.length());
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
