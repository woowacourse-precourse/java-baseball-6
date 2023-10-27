package baseball.compare;

import baseball.vo.InputNumbers;
import baseball.vo.RandomNumbers;

import java.util.List;

public class BaseBallCompare {
    private boolean[] check;
    private int strike;
    private int ball;

    private void initScore() {
        this.check = new boolean[10];
        this.strike = 0;
        this.ball = 0;
    }

    public boolean compare(RandomNumbers randoms, InputNumbers inputs) {
        initScore();
        int[] inputNumbers = inputs.getInputNumbers();
        List<Integer> randomNumbers = randoms.getRandomNumbers();

        for (int i = 0; i < inputNumbers.length; i++) {
            if (isStrike(randomNumbers, inputNumbers, i)) {
                continue;
            }

            isBall(randomNumbers, inputNumbers, i);
        }

        return threeStrikeCheck();
    }

    private boolean isStrike(List<Integer> randomNumbers,
                             int[] inputNumbers, int index) {
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

    private void isBall(List<Integer> randomNumbers,
                        int[] inputNumbers, int index) {
        if (randomNumbers.contains(inputNumbers[index]) &&
                !check[inputNumbers[index]]) {
            check[inputNumbers[index]] = true;
            ball++;
        }
    }

    public String getResultMessage() {
        StringBuilder sb = new StringBuilder();

        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }

        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }

        return sb.length() != 0 ? sb.toString().trim() : "낫싱";
    }

    public boolean threeStrikeCheck() {
        return strike == 3;
    }
}