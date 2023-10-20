package baseball.domain;

import java.util.List;

public class GameInfo {
    private int ball;
    private int strike;
    private List<Integer> randomNumbers;

    public GameInfo() {
        this.ball = 0;
        this.strike = 0;
    }

    public void updateBall(int ball) {
        this.ball = ball;
    }

    public void updateStrike(int strike) {
        this.strike = strike;
    }

    public int getStrike() {
        return strike;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public void createRandomNumber(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }
}
