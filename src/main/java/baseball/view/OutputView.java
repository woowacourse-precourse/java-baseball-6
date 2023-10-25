package baseball.view;

import baseball.model.GameResult;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String BALL_TEMPLATE = "볼";
    private static final String STRIKE_TEMPLATE = "스트라이크";
    private static final String NOTHING_TEMPLATE = "낫싱";

    public void showStart()  {
        System.out.println(START_MESSAGE);
    }

    public void showResult(GameResult result) {
        String message = "";
        int strike = result.getStrikeCount(), ball = result.getBallCount();

        if (ball != 0) {
            message += (ball + BALL_TEMPLATE);
        }

        if (ball != 0 && strike != 0) {
            message += " ";
        }

        if (strike != 0) {
            message += (strike + STRIKE_TEMPLATE);
        }

        if (ball == 0 && strike == 0) {
           message = NOTHING_TEMPLATE;
        }

        System.out.println(message);
    }

    public void showEnd() {
        System.out.println(END_MESSAGE);
    }
}
