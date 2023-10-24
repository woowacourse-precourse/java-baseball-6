package baseball.service;

import baseball.domain.Constants;
import java.util.List;

public class Referee {

    public static int calculateStrikeCount(List<Integer> computer, List<Integer> user) {
        int strikes = 0;
        for (int i = 0; i < Constants.NUMBER_LENGTH; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    public static int calculateBallCount(List<Integer> computer, List<Integer> user) {
        int balls = 0;
        for (int i = 0; i < Constants.NUMBER_LENGTH; i++) {
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    public static boolean isGameFinished(int strikeCount) {
        return strikeCount == Constants.NUMBER_LENGTH;
    }
}
