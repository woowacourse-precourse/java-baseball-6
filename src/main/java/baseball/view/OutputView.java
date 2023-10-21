package baseball.view;

import baseball.domain.GameResultDTO;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String NOTHING_MESSAGE = "낫싱";

    private static int NOTHING = 0;

    public void printGameResult(GameResultDTO gameResultDTO) {
        if (isNothing(gameResultDTO)) {
            printNothing();
            return;
        }
        printBallAndStrike(gameResultDTO);
    }

    private boolean isNothing(GameResultDTO gameResultDTO) {
        return gameResultDTO.getBall() == NOTHING && gameResultDTO.getStrike() == NOTHING;
    }

    private void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

    private void printBallAndStrike(GameResultDTO gameResultDTO) {
        if (isOnlyBall(gameResultDTO)) {
            printBall(gameResultDTO.getBall());
            System.out.println();
            return;
        }
        if (isOnlyStrike(gameResultDTO)) {
            printStrike(gameResultDTO.getStrike());
            return;
        }
        printBall(gameResultDTO.getBall());
        printStrike(gameResultDTO.getStrike());
    }

    private boolean isOnlyBall(GameResultDTO gameResultDTO) {
        return gameResultDTO.getStrike() == NOTHING;
    }

    private boolean isOnlyStrike(GameResultDTO gameResultDTO) {
        return gameResultDTO.getBall() == NOTHING;
    }

    private void printBall(int ball) {
        System.out.print(ball);
        System.out.print(BALL_MESSAGE);
    }

    private void printStrike(int strike) {
        System.out.print(strike);
        System.out.println(STRIKE_MESSAGE);
    }

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameFinish() {
        System.out.println(GAME_FINISH_MESSAGE);
    }
}
