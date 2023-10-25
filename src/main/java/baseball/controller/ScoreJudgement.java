package baseball.controller;

import java.util.Arrays;
import java.util.HashSet;

public class ScoreJudgement {

    public static int countStrike(int computerNumber, int userNumber) {
        String computerValue = String.valueOf(computerNumber);
        String userValue = String.valueOf(userNumber);
        int count = 0;

        for (int i = 0; i < computerValue.length(); i++) {
            if (computerValue.charAt(i) == userValue.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static int countSameNumber(int computerNumber, int userNumber) {
        String[] computerValue = String.valueOf(computerNumber).split("");
        String[] userValue = String.valueOf(userNumber).split("");
        int count = 0;
        HashSet<String> computerSet = new HashSet<>(Arrays.asList(computerValue));

        for (String character : userValue) {
            if (computerSet.contains(character)) {
                count++;
            }
        }
        return count;
    }
}
