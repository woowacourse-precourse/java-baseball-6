package baseball.view;

import baseball.domain.MyNumber;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String NO_STRIKE_AND_NO_BALL_MESSAGE = "낫싱";
    private static final int ZERO_VALUE = 0;

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printEndMessage() {
        System.out.println(GAME_END_MESSAGE);
        System.out.println(GAME_RESTART_OR_END_MESSAGE);
    }

    public void printMyNumberResult(MyNumber myNumber) {
        int ball = myNumber.getBall();
        int strike = myNumber.getStrike();

        if (ball != ZERO_VALUE && strike != ZERO_VALUE) {
            System.out.println(ball + BALL_MESSAGE + strike + STRIKE_MESSAGE);
        }
        if (ball != ZERO_VALUE && strike == ZERO_VALUE) {
            System.out.println(ball + BALL_MESSAGE);
        }
        if (ball == ZERO_VALUE && strike != ZERO_VALUE) {
            System.out.println(strike + STRIKE_MESSAGE);
        }
        if (ball == ZERO_VALUE && strike == ZERO_VALUE) {
            System.out.println(NO_STRIKE_AND_NO_BALL_MESSAGE);
        }
    }
}
