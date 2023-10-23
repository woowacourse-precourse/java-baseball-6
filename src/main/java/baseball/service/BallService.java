package baseball.service;

import baseball.model.BallNumber;
import baseball.model.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallService {

    private static final String ILLEGAL_ARGUMENT = "입력값이 잘못되었습니다.";

    public BaseballNumber generateRandomNum() {
        List<BallNumber> ballNumberList = new ArrayList<>();
        while (ballNumberList.size() < 3) {
            BallNumber ballNumber = new BallNumber(Randoms.pickNumberInRange(1, 9));

            if (!ballNumberList.contains(ballNumber)) {
                ballNumberList.add(ballNumber);
            }
        }

        return new BaseballNumber(ballNumberList);
    }

    public BaseballNumber initUserNumber(String inputReadLine) {
        validInputSize(inputReadLine);

        List<BallNumber> ballNumberList = new ArrayList<>();

        char[] charArray = inputReadLine.toCharArray();
        for (char c : charArray) {
            BallNumber ballNumber = new BallNumber(Character.getNumericValue(c));
            ballNumberList.add(ballNumber);
        }
        validDuplicateBallNumber(ballNumberList);

        return new BaseballNumber(ballNumberList);
    }

    private void validInputSize(String inputReadLine) {
        if (inputReadLine.length() != 3) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT);
        }
    }

    private void validDuplicateBallNumber(List<BallNumber> ballNumberList) {
        Set<BallNumber> ballNumberSet = new HashSet<>(ballNumberList);
        if (ballNumberSet.size() != ballNumberList.size()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT);
        }
    }
}
