package baseball_oop.enums;

public enum ReplyOrNot {
    REPLY("1"),
    END("2");

    public final String code;

    ReplyOrNot(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
