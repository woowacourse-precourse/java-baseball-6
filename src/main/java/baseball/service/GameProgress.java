package baseball.service;

import java.util.List;
import java.util.Map;

public class GameProgress {

    private static final String STRIKE = "strike";
    private static final String BALL = "ball";

    public Map<String, Integer> compareNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {
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

        return Map.of(STRIKE, strikes, BALL, balls);
    }

    public boolean isEndGame(Map<String, Integer> result) {

        return result.get(STRIKE) == 3;
    }

    public boolean decideGameRestart(int userNumber) {

        return userNumber == 1;
    }

    private boolean isStrike(List<Integer> computerNumbers, List<Integer> userNumbers, int index) {

        return computerNumbers.get(index).equals(userNumbers.get(index));
    }

    private boolean isBall(List<Integer> computerNumbers, Integer userNumber) {

        return computerNumbers.contains(userNumber);
    }
}
