package edu.school.utilities;

public enum ActionTypeEnum {
    APPROVE("aprobado"),
    DENY("negado"),
    CANCEL("cancelado"),
    RESTART("re-comenzar"),
    RESOLVE("resuelto");

    private final String actionTypeName;

    ActionTypeEnum(String actionTypeName) {
        this.actionTypeName = actionTypeName;
    }

    public String actionTypeName() {
        return actionTypeName;
    }
}
