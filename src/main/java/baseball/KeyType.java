package baseball;

public enum KeyType {
    STRIKE("스트라이크"),
    BALL("볼");

    private final String key;

    KeyType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}