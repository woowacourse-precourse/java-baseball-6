package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {

    public Computer() {
    }

    public List<Integer> createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }
        return computerNumber;
    }

    public List<Integer> compareEachNumber(List<Integer> computerNumber, List<Integer> userNumber) {
        List<Integer> resultCount = new ArrayList<>(Arrays.asList(0, 0));

        countStrike(computerNumber, userNumber, resultCount);
        countBall(computerNumber, userNumber, resultCount);
        removeDuplicateBallCount(resultCount);

        return resultCount;
    }

    private void removeDuplicateBallCount(List<Integer> resultCount) {
        resultCount.set(0, resultCount.get(0) - resultCount.get(1));
    }

    private void countBall(List<Integer> computerNumber, List<Integer> userNumber, List<Integer> resultCount) {
        for (int number : userNumber) {
            if (computerNumber.contains(number)) {
                resultCount.set(0, resultCount.get(0) + 1);
            }
        }
    }

    private void countStrike(List<Integer> computerNumber, List<Integer> userNumber, List<Integer> resultCount) {
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                resultCount.set(1, resultCount.get(1) + 1);
            }
        }
    }

    public void createResultMessage() {
    }

    public void checkResult() {
    }

    public void decideGameEndAndRestart() {
    }


}
