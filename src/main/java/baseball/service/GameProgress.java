package baseball.service;

import baseball.model.CompareResult;

import java.util.List;

public class GameProgress {

    private static final int TOTAL_NUMBER_COUNT = 3;
    private static final int RESTART_NUMBER = 1;

    public CompareResult compareNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (isStrike(computerNumbers, userNumbers, i)) {
                strikes++;
                continue;
            }
            if (isBall(computerNumbers, userNumbers.get(i))) {
                balls++;
            }
        }

        return new CompareResult(strikes, balls);
    }

    public boolean isEndGame(CompareResult compareResult) {

        return compareResult.strikes() == TOTAL_NUMBER_COUNT;
    }

    public boolean decideGameRestart(int userNumber) {

        return userNumber == RESTART_NUMBER;
    }

    private boolean isStrike(List<Integer> computerNumbers, List<Integer> userNumbers, int index) {

        return computerNumbers.get(index).equals(userNumbers.get(index));
    }

    private boolean isBall(List<Integer> computerNumbers, Integer userNumber) {

        return computerNumbers.contains(userNumber);
    }
}
