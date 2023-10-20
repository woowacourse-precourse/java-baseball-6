package baseball.view;

import baseball.domain.GameResult;

public class OutputView {

    private final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private final String NOTHING = "낫싱";
    private final String BALL = "%d볼";
    private final String STRIKE = "%d스트라이크";
    public void gameStart() {
        System.out.println(GAME_START);
    }
    public void outputResult(GameResult result) {
        if (result.isNothing()) {
            System.out.println(NOTHING);
        }
        if (result.hasBall() && result.hasStrike()) {
            System.out.printf(BALL+" "+STRIKE,result.getBall(),result.getStrike());
            return;
        }
        if (result.hasBall()) {
            System.out.printf(BALL,result.getBall());
        }
        if (result.hasStrike()) {
            System.out.printf(STRIKE,result.getStrike());
        }
    }
}
