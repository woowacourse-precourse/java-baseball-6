package baseball.domain;

import java.util.List;

public class ResultChecker {
    private int strike;
    private int ball;

    public ResultChecker(NumberBaseball computer, NumberBaseball user) {
        List<Integer> computerNumbers = computer.getNumbers();
        List<Integer> userNumbers = user.getNumbers();

        for (int i = 0; i < computerNumbers.size(); i++) {
            checkStrikeAndBall(computerNumbers.get(i), userNumbers.get(i), i, computerNumbers);
        }
    }

    private void checkStrikeAndBall(int computerNumber, int userNumber, int index, List<Integer> computerNumbers) {
        if (computerNumber == userNumber) {
            strike++;
            return;
        }
        if (computerNumbers.contains(userNumber)) {
            ball++;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isAllStrikes(int count) {
        return strike == count;
    }
}