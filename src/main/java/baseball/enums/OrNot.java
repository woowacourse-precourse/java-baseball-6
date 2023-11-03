package baseball.enums;

public enum OrNot {
    YES("1"),
    NO("2");
    private String processCode;

    OrNot(String processCode) {
        this.processCode = processCode;
    }

    public String getProcessCode() {
        return processCode;
    }
}
