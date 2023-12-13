package baseball.view;

import java.util.List;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BALL_STRIKE_GAME_SCORE = "%d볼 %d스트라이크%n";
    private static final String STRIKE_GAME_SCORE = "%d스트라이크%n";
    private static final String BALL_GAME_SCORE = "%d볼%n";
    private static final String NOTING = "낫싱";
    private static final String COMPLETED_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CLOSE_MESSAGE = "게임 종료";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void gameScore(List<Integer> gameResult) {
        int strikes = gameResult.get(1);
        int balls = gameResult.get(0);

        printNotingMessage(strikes, balls);
        strikeBall(strikes, balls);
        ball(strikes, balls);
        strike(strikes, balls);
    }

    private void strike(final int strike, final int ball) {
        if (ball == 0 && strike != 0) {
            System.out.printf(STRIKE_GAME_SCORE, strike);
        }
    }

    private void ball(final int strike, final int ball) {
        if (ball != 0 && strike == 0) {
            System.out.printf(BALL_GAME_SCORE, ball);
        }
    }

    private void strikeBall(final int strike, final int ball) {
        if (ball != 0 && strike != 0) {
            System.out.printf(BALL_STRIKE_GAME_SCORE, ball, strike);
        }
    }

    public void printNotingMessage(final int strike, final int ball) {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTING);
        }
    }

    public void gameResult(final int strikeCount) {
        System.out.printf(STRIKE_GAME_SCORE, strikeCount);
        System.out.println(COMPLETED_MESSAGE);
    }

    public void printCloseGame() {
        System.out.println(CLOSE_MESSAGE);
    }
}
