package baseball.domain.game;

public enum Input {
    NUMLENGTH(3);
    public int length;
    Input(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
