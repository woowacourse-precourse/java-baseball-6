package view;

import util.GameMessage;

public class GameScoreView {

    private static final int STRIKE_COUNT_INDEX = 0;
    private static final int BALL_COUNT_INDEX = 1;

    public void completeThreeStrikeScore() { // 3스트라이크 완성
        System.out.println("3스트라이크");
        System.out.println(GameMessage.FINISH_MESSAGE);
        System.out.println(GameMessage.RESTART_SELECT_MESSAGE);
    }
}
