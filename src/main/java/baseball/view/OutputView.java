package baseball.view;

import baseball.model.Score;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_WON_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_AND_STRIKE_FORMAT = "%d볼 %d스트라이크%n";
    private static final String BALL_ONLY_FORMAT = "%d볼%n";
    private static final String STRIKE_ONLY_FORMAT = "%d스트라이크%n";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printRoundResult(Score score) {
        if (score.isGameWon()) {
            printGameWonMessage(score.strikes());
            return;
        }

        if (score.isNothing()) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        printPartialScore(score);
    }

    private static void printGameWonMessage(int strikes) {
        System.out.printf(STRIKE_ONLY_FORMAT, strikes);
        System.out.println(GAME_WON_MESSAGE);
    }

    private static void printPartialScore(Score score) {
        if (score.isBall() && score.isStrike()) {
            System.out.printf(BALL_AND_STRIKE_FORMAT, score.balls(), score.strikes());
            return;
        }

        if (score.isBall()) {
            System.out.printf(BALL_ONLY_FORMAT, score.balls());
            return;
        }

        if (score.isStrike()) {
            System.out.printf(STRIKE_ONLY_FORMAT, score.strikes());
        }
    }
}
