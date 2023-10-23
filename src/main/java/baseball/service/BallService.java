package baseball.service;

import baseball.model.BallNumber;
import baseball.model.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallService {

    private final String ILLEGAL_ARGUMENT = "입력값이 잘못되었습니다.";

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
        try {
            List<BallNumber> ballNumberList = convertInputToBallNumberList(inputReadLine);

            validDuplicate(ballNumberList);

            return new BaseballNumber(ballNumberList);
        } catch (Exception e) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT);
        }
    }

    private List<BallNumber> convertInputToBallNumberList(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT);
        }

        List<BallNumber> ballNumberList = new ArrayList<>();

        char[] inputChar = input.toCharArray();
        for (char c : inputChar) {
            ballNumberList.add(new BallNumber(Character.getNumericValue(c)));
        }

        return ballNumberList;
    }

    private void validDuplicate(List<BallNumber> ballNumberList) {
        Set<BallNumber> ballNumberSet = new HashSet<>(ballNumberList);
        if (ballNumberSet.size() != ballNumberList.size()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT);
        }
    }
}
