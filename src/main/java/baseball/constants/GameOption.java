package baseball.constants;

public enum GameOption {
    ANSWER_NUMBER_LENGTH(3);

    private int length;
    GameOption(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }
}
