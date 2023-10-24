package model;

import java.util.List;
import vo.BallAndStrike;
import vo.UserNumbers;

public class BallAndStrikeChecker {

    private List<Integer> answer;
    private boolean gameProgress = true;

    public BallAndStrikeChecker(List<Integer> questionNumber) {
        this.answer = questionNumber;
    }

    public boolean gameProgress() {
        return gameProgress;
    }

    public BallAndStrike getBallAndStrike(UserNumbers userNumbers) {
        int ball = 0;
        int strike = 0;
        List<Integer> userNumberList = userNumbers.getUserNumberList();

        for (int i = 0; i < 3; i++) {
            Integer answerNumber = answer.get(i);
            Integer userNumber = userNumberList.get(i);

            if (answerNumber.equals(userNumber)) {
                strike++;
            } else if (answer.contains(userNumber)) {
                ball++;
            }
        }
        gameProgressChecker(strike);
        return new BallAndStrike(ball, strike);
    }

    private void gameProgressChecker(int strike) {
        if (strike == 3) {
            gameProgress = false;
        }
    }
}
