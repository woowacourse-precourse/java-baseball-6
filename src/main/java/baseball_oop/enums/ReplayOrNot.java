package baseball_oop.enums;

public enum ReplayOrNot {
    REPLAY("1"),
    END("2");

    public final String code;

    ReplayOrNot(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
