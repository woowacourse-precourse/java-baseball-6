package baseball.view;

import baseball.domain.GameResult;

public class OutputView {

    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String NOTHING = "낫싱";
    private static final String BALL_FORMAT = "%d볼 ";
    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String GAME_SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void gameStart() {
        System.out.println(GAME_START);
    }
    public static void printGameResult(GameResult result) {
        String hint = "";

        if (result.isNothing()) {
            System.out.println(NOTHING);
            return;
        }
        if (result.hasBall()) {
            hint += String.format(BALL_FORMAT, result.getBall());
        }
        if (result.hasStrike()) {
            hint += String.format(STRIKE_FORMAT, result.getStrike());
        }
        System.out.println(hint);
    }

    public static void gameSuccess() {
        System.out.println(GAME_SUCCESS);
    }
}
