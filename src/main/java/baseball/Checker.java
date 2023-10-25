package baseball;

import java.util.List;

public class Checker {

    public static int checkBallNumbers(List<Integer> computerNumber, List<Integer> userGuess) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computerNumber.get(i).equals(userGuess.get(j))) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    public static int checkStrikeNumbers(List<Integer> computerNumber, List<Integer> userGuess) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(userGuess.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

}
