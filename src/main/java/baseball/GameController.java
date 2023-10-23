package baseball;

import static baseball.Application.beginGame;
import static baseball.Constant.RESTART;

import java.util.List;

public class GameController {
    private final UserInput userInput;
    private final MatchCalculator matchCalculator;
    private final OutputView outputView;
    private final List<Integer> computerNum;
    private static boolean hasWon;

    GameController() {
        Computer computer = new Computer();
        userInput = new UserInput();
        outputView = new OutputView();
        matchCalculator = new MatchCalculator();
        computer.generateRandomNum();
        computerNum = computer.getRandomNum();
    }

    public void proceedGame() {
        while (!hasWon) {
            userInput.promptUserInput();
            List<Integer> userGuess = userInput.getUserNum();
            int[] matchResult = matchCalculator.checkMatch(computerNum, userGuess);
            outputView.printMatchResult(matchResult[0], matchResult[1]);
        }
        outputView.gameOvermessage();
        restartOrExit(userInput.promptUserForRestart());
    }

    private void restartOrExit(int userAnswer) {
        if (userAnswer == RESTART) {
            hasWon = false;
            beginGame();
        }
    }

    public static void hasWon() {
        hasWon = true;
    }
}
