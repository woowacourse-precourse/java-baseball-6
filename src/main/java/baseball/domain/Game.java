package baseball.domain;

import baseball.utils.Range;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Game {
    public static final int NO_STRIKE = 0;
    public static final int NO_BALL = 0;
    public static final int ALL_STRIKE = Range.VALID_INPUT_SIZE.getRange();
    private int strike;
    private int ball;

    public Game(Set<Integer> answerNumber, List<Integer> userNumberList) {
        checkBallCount(answerNumber, userNumberList);
        checkStrikeCount(answerNumber, userNumberList);
    }

    public void checkStrikeCount(Set<Integer> answerNumber, List<Integer> numberList) {
        List<Integer> answerList = new ArrayList<>(answerNumber);
        strike = 0;
        for (int i = 0; i < answerList.size(); i++) {
            if (answerList.get(i).equals(numberList.get(i))) {
                strike++;
            }
        }
    }

    public void checkBallCount(Set<Integer> answer, List<Integer> userNumberList) {
        ball = 0;
        List<Integer> answerList = new ArrayList<>(answer);
        for (int i = 0; i < userNumberList.size(); i++) {
            if (answerList.contains(userNumberList.get(i)) && !answerList.get(i).equals(userNumberList.get(i))) {
                ball++;
            }
        }
    }


    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isAnswer() {
        return strike == Range.VALID_INPUT_SIZE.getRange();
    }
}
