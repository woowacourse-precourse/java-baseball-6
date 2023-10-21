package baseball.service;

import baseball.domain.GameResult;
import baseball.domain.TargetNumber;
import baseball.domain.UserBaseballNumber;

import java.util.List;

public class BaseballGameService {

    public GameResult compareNumber(TargetNumber targetNumber, UserBaseballNumber userBaseballNumber) {
        List<Integer> computer = targetNumber.getComputerNumbers();
        List<Integer> userNumbers = userBaseballNumber.getUserValues();
        int strike = 0, ball = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.get(i) == computer.get(i)) {
                strike += 1;
            } else if (computer.contains(userNumbers.get(i))) {
                ball += 1;
            }
        }

        return new GameResult(strike, ball);
    }
}
