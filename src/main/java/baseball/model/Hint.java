package baseball.model;

public class Hint {
    private Integer strike;
    private Integer ball;

    public Hint() {
        this.strike = 0;
        this.ball = 0;
    }

    public void compareNumbers(Numbers computer, Numbers player) {
        this.strike = computer.countIdentity(player);
        this.ball = computer.countEquality(player);
    }
}
