package baseball.score;

import baseball.numbers.Numbers;

import java.util.List;

import static baseball.constant.Rule.*;

public class ScoreFactory {

    private boolean isStrike(int computerNumbers, int userNumber) {
        return computerNumbers == userNumber;
    }

    private boolean isBall(int userNumber, List<Integer> computerNumbers) {
        return computerNumbers.contains(userNumber);
    }

    public Score createScore(Numbers computer, Numbers user) {
        int strike = 0;
        int ball = 0;

        List<Integer> computerNumbers = computer.getNumbers();
        List<Integer> userNumbers = user.getNumbers();

        for (int index = 0; index < SIZE.getValue(); index++) {
            int computerNumber = computerNumbers.get(index);
            int userNumber = userNumbers.get(index);

            if (isStrike(computerNumber, userNumber)) {
                strike++;
                continue;
            }

            if (isBall(userNumber, computerNumbers)) {
                ball++;
            }
        }
        return new Score(strike, ball);
    }
}

