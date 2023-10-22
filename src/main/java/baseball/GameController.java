package baseball;

import java.util.List;

public class GameController {
    private Computer computer;
    private UserInput userInput;
    private boolean hasWon;
    private boolean isNothing;

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
    }

    public void checkMatch(List<Integer> computerNum, List<Integer> userNum) {
        checkIfNothing(computerNum, userNum);
        int strikeCount = countStrike(computerNum, userNum);
        int ballCount = countBall(computerNum, userNum);
        printResult(strikeCount, ballCount);
    }

    public void checkIfNothing(List<Integer> computerNum, List<Integer> userNum) {
        if (!computerNum.contains(userNum)) {
            isNothing = true;
        }
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
        if (isNothing) {
            System.out.println("낫싱");
            isNothing = !isNothing;
        }
        if (ballCount > 0) {
            System.out.printf("%d볼 ", ballCount);
        }
        if (strikeCount > 0) {
            System.out.printf("%d", strikeCount);
        }
        System.out.print("\n");
    }
}
