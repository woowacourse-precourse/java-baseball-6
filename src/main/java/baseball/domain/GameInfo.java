package baseball.domain;

import java.util.List;

/**
 * 게임에 대한 정보를 담는 클래스
 */
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

    public int getBall() {
        return ball;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public void createRandomNumber(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }
}
