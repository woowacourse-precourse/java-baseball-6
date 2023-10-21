package baseball;

import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {

    static int FINISH_STRIKE_CONDITION = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean startGame = true;
        while (startGame) {
            startGame();
        }
    }

    static void startGame() {
        OutputView.printStartMessage();
        boolean threeStrikes = false;
        List<Integer> computer = BaseballNumberGenerator.generateThreeDigits();
        while (!threeStrikes) {
            List<Integer> userNumbers = InputView.getThreeDigits();
            int strikeCounts = getStrikeCounts(computer, userNumbers);
            int ballCounts = getBallCounts(computer, userNumbers);
            OutputView.printResult(ballCounts, strikeCounts);
            if (isThreeStrike(strikeCounts)) {
                threeStrikes = true;
            }
        }
    }

    static boolean isThreeStrike(int strikeCounts) {
        if (strikeCounts == FINISH_STRIKE_CONDITION) {
            return true;
        }
        return false;
    }

    static int getStrikeCounts(List<Integer> computer, List<Integer> userNumbers) {
        int count = 0;
        for (int i = 0; i < computer.size(); ++i) {
            if (computer.get(i) == userNumbers.get(i)) {
                ++count;
            }
        }
        return count;
    }

    static int getBallCounts(List<Integer> computer, List<Integer> userNumbers) {
        int count = 0;
        for (int i = 0; i < computer.size(); ++i) {
            int computerNumber = computer.get(i);
            int userNumber = userNumbers.get(i);
            if (computerNumber != userNumber && computer.contains(userNumber)) {
                ++count;
            }
        }
        return count;
    }
}
