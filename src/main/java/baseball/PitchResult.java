package baseball;

public class PitchResult {
    private int ball;
    private int strike;

    private int restartNumber;
    private RandomNumber randomNumber;

    private Validation validation;

    public PitchResult(RandomNumber randomNumber, Validation validation) {
        this.randomNumber = randomNumber;
        this.validation = validation;
    }

    public void addBall(int ball) {
        this.ball = ball + 1;
    }

    public void addStrike(int strike) {
        this.strike = strike + 1;
    }

    public void setRestartNumber(int restartNumber) {
        this.restartNumber = restartNumber;
    }

    public int getRestartNumber() {
        return restartNumber;
    }
    

}
