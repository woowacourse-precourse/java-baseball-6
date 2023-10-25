package game;

public enum Status {

    PLAYING("1"),
    EXIT("2");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
