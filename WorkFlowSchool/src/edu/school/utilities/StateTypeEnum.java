package edu.school.utilities;

/**
 *
 * @author jgcastillo
 */
public enum StateTypeEnum {
    START("comienzo"),
    NORMAL("normal"),
    COMPLETE("completo"),
    DENIED("negado"),
    CANCELLED("cancelado");

    private final String stateTypeName;

    StateTypeEnum(String stateTypeName) {
        this.stateTypeName = stateTypeName;
    }

    public String stateTypeName() {
        return stateTypeName;
    }
}
