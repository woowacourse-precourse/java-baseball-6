package baseball.service;

import baseball.domain.GameNumberDTO;
import baseball.view.OutputView;
import java.util.List;

public class GameService {

    private static final int NO_COUNT = 0;
    private static final int THREE_STRIKES = 3;
    private int strike;
    private int ball;
    private static final String HINT_BALL = "볼";
    private static final String HINT_STRIKE = "스트라이크";
    private static final String HINT_NOTHING = "낫싱";

    OutputView outputView = new OutputView();

    public boolean gameToDo(GameNumberDTO gameNumber) {
        List<Integer> userNum = gameNumber.getUserNum();
        List<Integer> comNum = gameNumber.getComNum();

        compareNumber(userNum, comNum);

        return isThreeStrikes();
    }

    public void compareNumber(List<Integer> userNum, List<Integer> comNum) {
        ballAndStrikeInit();
        ballAndStrikeJudge(userNum, comNum);
        giveHint();
    }

    private void ballAndStrikeInit() {
        strike = NO_COUNT;
        ball = NO_COUNT;
    }

    private void ballAndStrikeJudge(List<Integer> userNum, List<Integer> comNum) {
        for (int i = 0; i < 3; i++) {
            strikeCnt(userNum.get(i), comNum.get(i));
            ballCnt(comNum, userNum.get(i), i);
        }
    }

    private void giveHint() {
        String hintMsg = "";
        hintMsg += hintBall();
        hintMsg += hintStrike();
        hintMsg += hintNothing();

        outputView.hintMsg(hintMsg);
    }

    private String hintBall() {
        if (ball > NO_COUNT) {
            return ball + HINT_BALL + " ";
        }
        return "";
    }

    private String hintStrike() {
        if (strike > NO_COUNT) {
            return strike + HINT_STRIKE + " ";
        }
        return "";
    }

    private String hintNothing() {
        if (ball == NO_COUNT && strike == NO_COUNT) {
            return HINT_NOTHING;
        }
        return "";
    }

    private void strikeCnt(int userNum, int comNum) {
        if (userNum == comNum) {
            strike++;
        }
    }

    private void ballCnt(List<Integer> comNum, int userNum, int index) {
        if (comNum.get(index) != userNum && comNum.contains(userNum)) {
            ball++;
        }
    }

    private boolean isThreeStrikes() {
        return strike == THREE_STRIKES;
    }

}

