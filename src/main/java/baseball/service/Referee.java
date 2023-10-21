package baseball.service;

import java.util.List;

public class Referee {

    private static final int NUMBER_LENGTH = 3;

    public static int calculateStrikeCount(List<Integer> computer, List<Integer> user) {
        int strikes = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

}
