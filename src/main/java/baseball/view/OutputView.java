package baseball.view;

import baseball.model.PlayResult;

public class OutputView {

    private static final String GAME_START_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String BALL_MSG = "볼 ";
    private static final String STRIKE_MSG = "스트라이크";
    private static final String NOTHING_MSG = "낫싱";
    private static final String GAME_CLEAR_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printGameStart() {
        System.out.println(GAME_START_MSG);
    }

    public void printResult(PlayResult result) {
        String resultStr = "";
        if (result.hasBall()) resultStr += result.getBall() + BALL_MSG;
        if (result.hasStrike()) resultStr += result.getStrike() + STRIKE_MSG;
        if (result.isNothing()) resultStr += NOTHING_MSG;
        System.out.println(resultStr.trim());
    }

    public void printGameClear() {
        System.out.println(GAME_CLEAR_MSG);
    }
}
