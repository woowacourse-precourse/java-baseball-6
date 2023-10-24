package baseball;

import static baseball.Application.beginGame;
import static baseball.Constant.RESTART;

import java.util.List;

public class GameController {
    private final Computer computer;
    private final UserInput userInput;
    private final MatchCalculator matchCalculator;
    private final OutputView outputView;
    private List<Integer> computerNum;
    private static boolean hasWon;

    GameController() {
        computer = new Computer();
        userInput = new UserInput();
        outputView = new OutputView();
        matchCalculator = new MatchCalculator();
    }

    public void proceedGame() {
        setupGame();
        while (!hasWon) {
            loopThroughGame();
        }
        outputView.gameOverMessage();
        restartOrExit(userInput.promptUserForRestart());
    }

    private void setupGame() {
        computer.generateRandomNum();
        computerNum = computer.getRandomNum();
    }

    private void loopThroughGame() {
        userInput.promptUserInput();
        List<Integer> userGuess = userInput.getUserNum();
        int[] matchResult = matchCalculator.checkMatch(computerNum, userGuess);
        outputView.printMatchResult(matchResult[0], matchResult[1]);
    }

    private void restartOrExit(int userAnswer) {
        if (userAnswer == RESTART) {
            hasWon = false;
            beginGame();
        }
    }

    public static void victory() {
        hasWon = true;
    }
}
