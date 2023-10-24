package baseball.service;

import baseball.vo.InputNumbers;
import baseball.vo.RandomNumbers;

import java.util.List;

public class BaseBallCompare {
    private StringBuilder sb;
    private List<Integer> randomNumbers;
    private boolean[] check;
    private int strike;
    private int ball;

    private void initScore() {
        this.check = new boolean[10];
        this.strike = 0;
        this.ball = 0;
    }

    public void setRandomNumbers() {
        this.randomNumbers = new RandomNumbers().getRandomNumbers();
    }

    public boolean compare(InputNumbers inputs) {
        initScore();
        int[] inputNumbers = inputs.getInputNumbers();

        for (int i = 0; i < inputNumbers.length; i++) {
            if (isStrike(inputNumbers, i)) {
                continue;
            }

            isBall(inputNumbers, i);
        }

        return threeStrikeCheck();
    }

    private boolean isStrike(int[] inputNumbers, int index) {
        if (randomNumbers.get(index) == inputNumbers[index]) {
            if (check[inputNumbers[index]]) {
                ball--;
            }

            check[inputNumbers[index]] = true;
            strike++;
            return true;
        }

        return false;
    }

    private void isBall(int[] inputNumbers, int index) {
        if (randomNumbers.contains(inputNumbers[index]) &&
                !check[inputNumbers[index]]) {
            check[inputNumbers[index]] = true;
            ball++;
        }
    }

    public String getResultMessage() {
        sb = new StringBuilder();

        if (ball != 0) {
            sb.append(ball + "볼 ");
        }

        if (strike != 0) {
            sb.append(strike + "스트라이크");
        }

        return sb.length() != 0 ? sb.toString() : "낫싱";
    }

    public boolean threeStrikeCheck() {
        return strike == 3;
    }
}