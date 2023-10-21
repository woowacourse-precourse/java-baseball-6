package baseball.domain;

public enum PlayerType {
    HUMAN("HUMAN"),COMPUTER("COMPUTER");
    private final String name;

    PlayerType(String name) {
        this.name = name;
    }
}
