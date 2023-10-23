package baseball;

import java.util.List;

public class Result {
    private int ball;
    private int strike;

    public void calculate(List<Character> userNumbers, List<Character> randomNumbers) {
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
            result = "낫싱";
        }

        if (ball != 0) {
            result += ball + "볼 ";
        }

        if (strike != 0) {
            result += strike + "스트라이크";
        }

        return result;
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
