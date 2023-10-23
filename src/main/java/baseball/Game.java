package baseball;

import java.util.List;

public class Game {
    private int strike =  0;
    private int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void setZero() {
        this.strike = 0;
        this.ball = 0;
    }

    public void countStrike(List<Integer> randomNumbers, List<Integer> inputNumbers) {
        int count = 0;
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i) == inputNumbers.get(i)) {
                count++;
            }
        }
        this.strike = count;
    }

    public void countBall(List<Integer> randomNumbers, List<Integer> inputNumbers) {
        int count = 0;
        for (Integer inputNumber : inputNumbers) {
            if (randomNumbers.contains(inputNumber)) {
                count++;
            }
        }
        this.ball = count-this.strike;
    }


}
