package edu.school.utilities;

public enum ActionTypeEnum {
    APPROVE("Aprobadar"),
    DENY("Negar"),
    CANCEL("Cancelar"),
    RESTART("Reiniciar"),
    RESOLVE("Resolver");

    private final String actionTypeName;

    ActionTypeEnum(String actionTypeName) {
        this.actionTypeName = actionTypeName;
    }

    public String actionTypeName() {
        return actionTypeName;
    }
}
