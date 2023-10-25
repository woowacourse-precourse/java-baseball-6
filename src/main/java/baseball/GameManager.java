package baseball;

import baseball.number.GameNumber;
import baseball.number.GameNumberGenerator;
import baseball.number.RestartNumber;
import baseball.printer.ConsoleGamePrinter;
import baseball.printer.GamePrinter;
import baseball.receiver.ConsoleGameReceiver;
import baseball.receiver.GameReceiver;

import java.io.BufferedReader;
import java.io.IOException;

public class GameManager {
    private static final Integer MIN_COUNT = 0;
    private static final Integer MAX_COUNT = 3;
    private static final Integer COUNT_INIT_NUMBER = 0;
    private static final Integer LOOP_START_NUMBER = 0;
    private static final Integer NUMBER_SIZE = 3;

    private final GameReceiver gameReceiver;
    private final GamePrinter gamePrinter;

    public GameManager(BufferedReader receiver) {
        this.gameReceiver = new ConsoleGameReceiver(receiver);
        this.gamePrinter = new ConsoleGamePrinter();
    }

    public void run() {
        gamePrinter.greet();

        boolean restartStatus = true;

        while (restartStatus) {
            GameNumber gameNumber = new GameNumber(GameNumberGenerator.generateGameNumber());
            playBall(gameNumber);
            restartStatus = askRestartGame();
        }
    }

    private void playBall(GameNumber gameNumber) {
        boolean isContinue = true;

        while (isContinue) {
            gamePrinter.requestInputGameNumber();
            GameNumber userNumber;
            try {
                userNumber = new GameNumber(gameReceiver.receive());
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
            isContinue = calculateBallCount(gameNumber, userNumber);
        }
    }

    private boolean calculateBallCount(GameNumber gameNumber, GameNumber userNumber) {
        boolean isContinue = true;
        Integer strikeCount;
        Integer ballCount;

        strikeCount = calculateStrike(gameNumber.getValue(), userNumber.getValue());
        ballCount = calculateBall(gameNumber.getValue(), userNumber.getValue());

        if (strikeCount == MIN_COUNT && ballCount == MIN_COUNT) {
            gamePrinter.printNothing();
        } else if (strikeCount > MIN_COUNT && strikeCount < MAX_COUNT && ballCount == MIN_COUNT) {
            gamePrinter.printStrikeCount(strikeCount.toString());
        } else if (ballCount > MIN_COUNT && strikeCount == MIN_COUNT) {
            gamePrinter.printBallCount(ballCount.toString());
        } else if (strikeCount == MAX_COUNT) {
            gamePrinter.printStrikeCount(strikeCount.toString());
            gamePrinter.noticeWin();
            isContinue = false;
        } else {
            gamePrinter.printBallAndStrikeCount(strikeCount.toString(), ballCount.toString());
        }
        return isContinue;
    }

    private Integer calculateStrike(String gameNumber, String userNumber) {
        Integer strikeCount = COUNT_INIT_NUMBER;
        for (int index = LOOP_START_NUMBER; index < NUMBER_SIZE; index++) {
            if (gameNumber.charAt(index) == userNumber.charAt(index)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private Integer calculateBall(String gameNumber, String userNumber) {
        Integer ballCount = COUNT_INIT_NUMBER;
        for (int gameNumberIndex = LOOP_START_NUMBER; gameNumberIndex < NUMBER_SIZE; gameNumberIndex++) {
            for (int userNumberIndex = LOOP_START_NUMBER; userNumberIndex < NUMBER_SIZE; userNumberIndex++) {
                if (gameNumberIndex == userNumberIndex) {
                    continue;
                }

                if (gameNumber.charAt(gameNumberIndex) == userNumber.charAt(userNumberIndex)) {
                    ballCount++;
                }
            }
        }

        return ballCount;
    }

    private boolean askRestartGame() {
        gamePrinter.requestInputRestartNumber();

        RestartNumber inputRestartNumber;
        try {
            inputRestartNumber = new RestartNumber(gameReceiver.receive());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return inputRestartNumber.getValue();
    }
}
