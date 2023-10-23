package baseball.game;

import static baseball.constant.NumberConstants.COUNT_ZERO;
import static baseball.output.GameOutput.printNewLine;
import static baseball.output.GameOutput.printlnNothing;

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
        int count = 0;
        for (int i = 0; i < userNumberString.length(); i++) {
            if (userNumberString.charAt(i) == computerNumberString.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private int countAllBalls(String userNumberString, String computerNumberString) {
        int count = 0;
        for (char c : userNumberString.toCharArray()) {
            if (computerNumberString.contains(Character.toString(c))) {
                count++;
            }
        }

        return count;
    }

    public void displayResult(GameResult gameResult) {
        if (gameResult.isNothing()) {
            printlnNothing();
            return;
        }

        if (gameResult.hasBalls()) {
            gameResult.callBallCount();
        }

        if (gameResult.hasStrikes()) {
            gameResult.callStrikeCount();
        }

        printNewLine();
    }

}
