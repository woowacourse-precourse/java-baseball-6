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

    public void printCount(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        } else if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
