package baseball.util;

import java.util.List;
import java.util.Objects;

public class CountResult {
    public static int ball;
    public static int strike;

    /*ball과 strike를 세는 메서드*/
    public static void countingResult(List<Integer> computerAns, List<Integer> userInput) {
        countingBall(computerAns, userInput);
        countingStrike(computerAns, userInput);
    }

    private static int countingBall(List<Integer> computerAns, List<Integer> userInput) {
        ball = 0;
        for (int i = 0; i < computerAns.size(); i++) {
            if (computerAns.contains(userInput.get(i)) && !computerAns.get(i).equals(userInput.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public static int countingStrike(List<Integer> computerAns, List<Integer> userInput) {
        strike = 0;
        for (int i = 0; i < computerAns.size(); i++) {
            if (Objects.equals(computerAns.get(i), userInput.get(i))) {
                strike++;
            }
        }
        return strike;
    }
}
