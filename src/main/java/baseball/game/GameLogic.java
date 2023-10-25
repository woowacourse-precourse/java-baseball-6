package baseball.game;

import static baseball.constant.NumberConstants.COUNT_ZERO;
import static baseball.game.GameOutput.printNewLine;
import static baseball.game.GameOutput.printlnNothing;

import java.util.stream.IntStream;

public class GameLogic {

    public GameResult initializeResult() {
        return new GameResult(COUNT_ZERO, COUNT_ZERO);
    }

    public GameResult makeResultCount(String userNumberString, String computerNumberString) {
        int strikeCount = countStrikes(userNumberString, computerNumberString);
        int ballCount = countAllBalls(userNumberString, computerNumberString) - strikeCount;

        return new GameResult(strikeCount, ballCount);
    }

    private int countStrikes(String userNumberString, String computerNumberString) {
        return (int) IntStream.range(0, userNumberString.length())
                .filter(i -> userNumberString.charAt(i) == computerNumberString.charAt(i))
                .count();
    }

    private int countAllBalls(String userNumberString, String computerNumberString) {
        return (int) userNumberString.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> computerNumberString.contains(Character.toString(c)))
                .count();
    }

    public void displayResult(GameResult gameResult) {
        if (gameResult.isNothing()) {
            printlnNothing();
            return;
        }

        displayBallCount(gameResult);
        displayStrikeCount(gameResult);
        printNewLine();
    }

    private void displayBallCount(GameResult gameResult) {
        if (gameResult.hasBalls()) {
            gameResult.callBallCount();
        }
    }

    private void displayStrikeCount(GameResult gameResult) {
        if (gameResult.hasStrikes()) {
            gameResult.callStrikeCount();
        }
    }

}
