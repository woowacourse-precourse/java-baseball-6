package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        View.printGameStart();
        boolean isGameOn = true;
        while (isGameOn) {
            List<Integer> computerNumbers = getComputerNumbers();
            compareLoop(computerNumbers);
            isGameOn = View.askRetry();
        }
    }

    private static List<Integer> getComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static void compareLoop(List<Integer> computerNumbers) {
        while (true) {
            List<Integer> userNumbers = View.getUserNumbers(NUMBER_LENGTH);
            int strikeCount = calculateStrike(computerNumbers, userNumbers);
            int ballCount = calculateBall(computerNumbers, userNumbers);
            View.printScore(strikeCount, ballCount);
            if (strikeCount == NUMBER_LENGTH) {
                View.printGameEnd(NUMBER_LENGTH);
                break;
            }
        }
    }

    private static int calculateStrike(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i) == userNumbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static int calculateBall(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int ballCount = 0;
        for (int j = 0; j < computerNumbers.size(); j++) {
            if (computerNumbers.get(j) != userNumbers.get(j) && computerNumbers.contains(userNumbers.get(j))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
