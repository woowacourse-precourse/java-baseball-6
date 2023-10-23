package baseball.service;

import baseball.model.BallNumber;
import baseball.model.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallService {

    private static final String ILLEGAL_ARGUMENT = "입력값이 잘못되었습니다.";

    public BaseballNumber generateRandomNum() {
        List<BallNumber> ballNumberList = new ArrayList<>();
        while (ballNumberList.size() < 3) {
            addBallNumberToList(ballNumberList, Randoms.pickNumberInRange(1, 9));
        }

        return new BaseballNumber(ballNumberList);
    }

    public BaseballNumber initUserNumber(String inputReadLine) {
        List<BallNumber> ballNumberList = new ArrayList<>();
        char[] charArray = inputReadLine.toCharArray();
        for (char c : charArray) {
            addBallNumberToList(ballNumberList, Character.getNumericValue(c));
        }
        validSize(ballNumberList.size());

        return new BaseballNumber(ballNumberList);
    }

    private void addBallNumberToList(List<BallNumber> ballNumberList, int num) {
        BallNumber ballNumber = new BallNumber(num);
        if (!ballNumberList.contains(ballNumber)) {
            ballNumberList.add(ballNumber);
        }
    }

    private void validSize(int size) {
        if (size != 3) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT);
        }
    }
}
