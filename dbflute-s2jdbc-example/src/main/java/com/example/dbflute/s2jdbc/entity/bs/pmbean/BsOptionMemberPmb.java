package com.example.dbflute.s2jdbc.entity.bs.pmbean;

/**
 * The parameter-bean of OptionMemberPmb.
 * @author DBFlute(AutoGenerator)
 */
public class BsOptionMemberPmb {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /**
     * memberId <br />
     */
    public Integer memberId;

    /**
     * memberName:like <br />
     */
    public String memberName;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsOptionMemberPmb() {
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
