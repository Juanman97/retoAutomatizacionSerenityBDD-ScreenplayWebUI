package co.com.sofka.util;

public enum RegisterUserTitle {
    MR_TITLE("Mr"),
    MRS_TITLE("Mrs");

    private final String value;

    public String getValue() {
        return value;
    }

    RegisterUserTitle(String value) {
        this.value = value;
    }

}
