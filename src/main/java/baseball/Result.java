package baseball;

import java.util.List;

public class Result {
    private int ballCount;
    private int strikeCount;

    private final String NOTHING = "낫싱";
    private final String BALL = "볼 ";
    private final String STRIKE = "스트라이크";

    public Result() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void calculate(List<Character> userNumbers, List<Character> randomNumbers) {
        setZero();

        for (int index = 0; index < userNumbers.size(); index++) {
            char number = userNumbers.get(index);

            if (isSameIndex(index, number, randomNumbers)) {
                strikeCount++;
            }

            if (!isSameIndex(index, number, randomNumbers) && isExistedIndex(number, randomNumbers)) {
                ballCount++;
            }
        }
    }

    public String isResult() {
        String result = "";

        if (isNothing()) {
            result = NOTHING;
        }

        if (ballCount != 0) {
            result += ballCount + BALL;
        }

        if (strikeCount != 0) {
            result += strikeCount + STRIKE;
        }

        return result;
    }

    private void setZero() {
        ballCount = 0;
        strikeCount = 0;
    }

    private boolean isExistedIndex(char number, List<Character> randomNubers) {
        return randomNubers.indexOf(number) != -1;
    }

    private boolean isSameIndex(int index, char number, List<Character> randomNumbers) {
        return index == randomNumbers.indexOf(number);
    }

    private boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }
}
