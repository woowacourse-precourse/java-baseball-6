package baseball;

import static baseball.Application.beginGame;
import static baseball.Constant.RESTART;
import static baseball.Constant.THREE_STRIKE;

import java.util.List;

public class GameController {
    private final Computer computer;
    private final UserInput userInput;
    private boolean hasWon;

    GameController() {
        computer = new Computer();
        computer.generateRandomNum();
        userInput = new UserInput();
    }

    public void proceedGame() {
        while (!hasWon) {
            userInput.promptUserInput();
            checkMatch(computer.getRandomNum(), userInput.getUserNum());
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restartOrExit(userInput.promptUserForRestart());
    }

    public void checkMatch(List<Integer> computerNum, List<Integer> userNum) {
        int strikeCount = countStrike(computerNum, userNum);
        int ballCount = countBall(computerNum, userNum);
        printResult(strikeCount, ballCount - strikeCount);
        checkWin(strikeCount);
    }

    public int countStrike(List<Integer> computerNum, List<Integer> userNum) {
        int count = 0;
        for (int i = 0; i < computerNum.size(); i++) {
            if (computerNum.get(i).equals(userNum.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int countBall(List<Integer> computerNum, List<Integer> userNum) {
        int count = 0;
        for (int i = 0; i < computerNum.size(); i++) {
            if (computerNum.contains(userNum.get(i))) {
                count++;
            }
        }
        return count;
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

    public void checkWin(int strikeCount) {
        if (strikeCount == THREE_STRIKE) {
            hasWon = true;
        }
    }

    public void restartOrExit(int userAnswer) {
        if (userAnswer == RESTART) {
            beginGame();
        }
    }
}
