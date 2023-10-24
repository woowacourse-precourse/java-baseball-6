package view;

import java.util.List;
import util.GameMessage;

public class GameScoreView {

    private static final int STRIKE_COUNT_INDEX = 0;
    private static final int BALL_COUNT_INDEX = 1;

    public void completeThreeStrikeScore() { // 3스트라이크 완성
        System.out.println(GameMessage.FINISH_MESSAGE);
        System.out.println(GameMessage.RESTART_SELECT_MESSAGE);
    }

    public void incompleteThreeStrikeScore(List<Integer> incompleteThreeStrikeScore) { // 3스트라이크 미완성
        int countStrike = incompleteThreeStrikeScore.get(STRIKE_COUNT_INDEX);
        int countBall = incompleteThreeStrikeScore.get(BALL_COUNT_INDEX);

        if (countStrike == 0 && countBall == 0) {
            System.out.println("낫싱");
        }
        if (countStrike != 0 && countBall == 0) {
            System.out.println(countStrike + "스트라이크");
        }
        if (countStrike == 0 && countBall != 0) {
            System.out.println(countBall + "볼");
        }
        if (countStrike != 0 && countBall != 0) {
            System.out.println(countBall + "볼 " + countStrike + "스트라이크");
        }
    }
}
