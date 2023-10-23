package baseball.view;

import baseball.model.PlayResult;

public class OutputView {

    private static final String GAME_START_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String BALL_MSG = "볼 ";
    private static final String STRIKE_MSG = "스트라이크";
    private static final String NOTHING_MSG = "낫싱";

    public void printGameStart() {
        System.out.println(GAME_START_MSG);
    }

    public void printResult(PlayResult result) {
        if (result.hasBall()) System.out.print(result.getBall() + BALL_MSG);
        if (result.hasStrike()) System.out.print(result.getStrike() + STRIKE_MSG);
        if (result.isNothing()) System.out.print(NOTHING_MSG);
        System.out.println();
    }
}
