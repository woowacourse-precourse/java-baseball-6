package baseball.domain;

public abstract class Player {
    public int ballCount;
    public int strikeCount;
    public int[] baseballNumber;

    abstract void guessBaseballNumber();
}
