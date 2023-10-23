package baseball;

import static baseball.Application.beginGame;
import static baseball.Constant.RESTART;

import java.util.List;

public class GameController {
    private final Computer computer;
    private final UserInput userInput;
    private final MatchCalculator matchCalculator;
    private final List<Integer> computerNum;
    private static boolean hasWon;

    GameController() {
        computer = new Computer();
        userInput = new UserInput();
        matchCalculator = new MatchCalculator();
        computer.generateRandomNum();
        computerNum = computer.getRandomNum();
    }

    public void proceedGame() {
        while (!hasWon) {
            userInput.promptUserInput();
            List<Integer> userGuess = userInput.getUserNum();
            int[] matchResult = matchCalculator.checkMatch(computerNum, userGuess);
            printResult(matchResult[0], matchResult[1]);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restartOrExit(userInput.promptUserForRestart());
    }


    public void printResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }
        if (ballCount > 0) {
            System.out.printf("%d볼 ", ballCount);
        }
        if (strikeCount > 0) {
            System.out.printf("%d스트라이크", strikeCount);
        }
        System.out.print("\n");
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
