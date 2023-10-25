package baseball.io;

import baseball.config.GameConfig;
import baseball.config.GameMessages;
import baseball.domain.GuessResult;

public class OutputManager {
    public void printStartMessage() {
        System.out.println(GameMessages.GAME_START);
    }
    public void printGuessMessage() {
        printMessage(GameMessages.INPUT_NUMBER, false);
    }

    public void printGuessResult(GuessResult result) {
        String strikeMsg, ballMsg;

        if (result.balls() > 0) {
            ballMsg = String.format(GameMessages.BALL, result.balls());
            printMessage(ballMsg, false);
        }
        if (result.strikes() > 0) {
            strikeMsg = String.format(GameMessages.STRIKE, result.strikes());
            printMessage(strikeMsg, false);
        }
        if (result.strikes() == 0 && result.balls() == 0) {
            printMessage(GameMessages.NOTHING, false);
        }
        printMessage("");
    }

    public void printGameOverMessage() {
        String gameOverMsg = String.format(GameMessages.GAME_OVER, GameConfig.DIGIT_COUNT.getValue());
        printMessage(gameOverMsg);
    }

    public void printReplayOrStopMessage() {
        String replayMsg = String.format(GameMessages.REPLAY_OR_STOP,
                GameConfig.REPLAY.getValue(),
                GameConfig.STOP.getValue());
        printMessage(replayMsg);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String message, boolean usePrintln) {
        if (usePrintln) {
            System.out.println(message);
            return;
        }
        System.out.print(message);
    }
}
