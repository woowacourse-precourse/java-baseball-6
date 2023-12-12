package baseball.view;

import baseball.domain.dto.GameResponse;

public class OutputView {

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String NOTHING_MESSAGE = "낫싱\n";
    public static final String BALL_MESSAGE = "%d볼\n";
    public static final String STRIKE_MESSAGE = "%d스트라이크\n";
    public static final String BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";


    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

    public static void printGameRestart() {
        System.out.println(GAME_RESTART_MESSAGE);
    }

    private static void printNothing(GameResponse response) {
        if (response.hasNoStrike() && response.hasNoBall()) {
            System.out.print(NOTHING_MESSAGE);
        }
    }

    private static void printBall(GameResponse response) {
        if (response.hasNoStrike() && !response.hasNoBall()) {
            System.out.printf(BALL_MESSAGE, response.getBall());
        }
    }

    private static void printStrike(GameResponse response) {
        if (!response.hasNoStrike() && response.hasNoBall()) {
            System.out.printf(STRIKE_MESSAGE, response.getStrike());
        }
    }

    private static void printBallStrike(GameResponse response) {
        if (!response.hasNoStrike() && !response.hasNoBall()) {
            System.out.printf(BALL_STRIKE_MESSAGE, response.getBall(), response.getStrike());
        }
    }

    public static void printGameResult(GameResponse response) {
        printNothing(response);
        printStrike(response);
        printBall(response);
        printBallStrike(response);
    }
}
