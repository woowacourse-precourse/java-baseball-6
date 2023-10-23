package baseball;

import static baseball.Application.beginGame;
import static baseball.Constant.RESTART;

import java.util.List;

public class GameController {
    private final Computer computer;
    private final UserInput userInput;
    private final MatchCalculator matchCalculator;
    private OutputView outputView;
    private final List<Integer> computerNum;
    private static boolean hasWon;

    GameController() {
        computer = new Computer();
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

    public void restartOrExit(int userAnswer) {
        if (userAnswer == RESTART) {
            hasWon = false;
            beginGame();
        }
    }

    public static void hasWon() {
        hasWon = true;
    }
}
