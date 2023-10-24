package baseball.service;

import baseball.model.Ball;
import baseball.model.BallNumbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallService {

    private static final String ILLEGAL_ARGUMENT = "입력값이 잘못되었습니다.";

    public BallNumbers generateRandomBallNumbers() {
        List<Ball> ballList = new ArrayList<>();
        while (ballList.size() < 3) {
            addBallToList(ballList, Randoms.pickNumberInRange(1, 9));
        }

        return new BallNumbers(ballList);
    }

    public BallNumbers initUserBallNumbers(String inputReadLine) {
        List<Ball> ballList = new ArrayList<>();
        char[] charArray = inputReadLine.toCharArray();
        for (char c : charArray) {
            addBallToList(ballList, Character.getNumericValue(c));
        }
        validSize(ballList.size());

        return new BallNumbers(ballList);
    }

    private void addBallToList(List<Ball> ballList, int num) {
        Ball ball = new Ball(num);
        if (!ballList.contains(ball)) {
            ballList.add(ball);
        }
    }

    private void validSize(int size) {
        if (size != 3) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT);
        }
    }
}
