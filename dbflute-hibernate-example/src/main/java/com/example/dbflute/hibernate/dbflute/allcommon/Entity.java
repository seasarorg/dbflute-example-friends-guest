package com.example.dbflute.hibernate.dbflute.allcommon;

/**
 * The interface of entity defined common columns.
 * @author DBFlute(AutoGenerator)
 */
public interface Entity {

    // ===================================================================================
    //                                                                      Display String
    //                                                                      ==============
    /**
     * @return The display string of basic informations with one-nested relation values. (NotNull)
     */
    public String toStringWithRelation();

    /**
     * @param name The name for display. (NullAllowed: If it's null, it does not have a name)
     * @param column Does it contains column values or not?
     * @param relation Does it contains relation existences or not?
     * @return The display string for this entity. (NotNull)
     */
    public String buildDisplayString(String name, boolean column, boolean relation);
}
