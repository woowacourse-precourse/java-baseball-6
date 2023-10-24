package baseball.view;

import baseball.model.Score;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_WON_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printRoundResult(Score score) {
        if (score.isGameWon()) {
            printGameWonMessage(score.strikes());
        } else if (score.strikes() == 0 && score.balls() == 0) {
            System.out.println(NOTHING_MESSAGE);
        } else {
            printPartialScore(score);
        }
    }

    private static void printGameWonMessage(int strikes) {
        System.out.printf("%d스트라이크%n", strikes);
        System.out.println(GAME_WON_MESSAGE);
    }

    private static void printPartialScore(Score score) {
        if (score.balls() > 0 && score.strikes() > 0) {
            System.out.printf("%d볼 %d스트라이크%n", score.balls(), score.strikes());
        } else if (score.balls() > 0) {
            System.out.printf("%d볼%n", score.balls());
        } else {
            System.out.printf("%d스트라이크%n", score.strikes());
        }
    }
}
