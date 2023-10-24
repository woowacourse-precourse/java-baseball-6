package baseball.view;

import baseball.model.GameResult;
import baseball.utils.Message;

public class OutputView {
    private final GameResult gameResult;

    public OutputView(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public static void printGameStart() {
        System.out.println(Message.START_GAME);
    }

    public static void printGameClear() {
        System.out.println(Message.GAME_CLEAR);
    }

    public void printResult() {
        printOnlyBall();
        printOnlyStrike();
        printBallAndStrike();
        printNothing();
    }

    private void printOnlyBall() {
        if (gameResult.getBall() != 0 && gameResult.getStrike() == 0) {
            System.out.println(gameResult.getBall() + Message.BALL);
        }
    }

    private void printOnlyStrike() {
        if (gameResult.getBall() == 0 && gameResult.getStrike() != 0) {
            System.out.println(gameResult.getStrike() + Message.STRIKE);
        }
    }

    private void printBallAndStrike() {
        if (gameResult.getBall() != 0 && gameResult.getStrike() != 0) {
            System.out.println(gameResult.getBall() + Message.BALL + gameResult.getStrike() + Message.STRIKE);
        }
    }

    private void printNothing() {
        if (gameResult.getBall() == 0 && gameResult.getStrike() == 0) {
            System.out.println(Message.NOTHING);
        }
    }
}
