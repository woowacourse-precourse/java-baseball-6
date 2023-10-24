package baseball;

import java.util.List;

public class Result {
    private int ball;
    private int strike;

    private final String NOTHING = "낫싱";
    private final String BALL = "볼 ";
    private final String STRIKE = "스트라이크";

    public Result() {
        this.ball = 0;
        this.strike = 0;
    }

    public void calculate(List<Character> userNumbers, List<Character> randomNumbers) {
        setZero();

        for (int index = 0; index < userNumbers.size(); index++) {
            char number = userNumbers.get(index);

            if (isSameIndex(index, number, randomNumbers)) {
                strike++;
            }

            if (!isSameIndex(index, number, randomNumbers) && isExistedIndex(number, randomNumbers)) {
                ball++;
            }
        }
    }

    public String isResult() {
        String result = "";

        if (isNothing()) {
            result = NOTHING;
        }

        if (ball != 0) {
            result += ball + BALL;
        }

        if (strike != 0) {
            result += strike + STRIKE;
        }

        return result;
    }

    private void setZero() {
        ball = 0;
        strike = 0;
    }

    private boolean isExistedIndex(char number, List<Character> randomNubers) {
        return randomNubers.indexOf(number) != -1;
    }

    private boolean isSameIndex(int index, char number, List<Character> randomNumbers) {
        return index == randomNumbers.indexOf(number);
    }

    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
