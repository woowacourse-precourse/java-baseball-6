package baseball.util;

import java.util.List;
import java.util.Objects;

public class CountResult {

    public static int ball;
    public static int strike;

//    public static int resultCount(List<Integer> computer, List<Integer> input) {
//        countingBall(computer, input);
//        countingStrike(computer, input);
//    }

    public static int countingBall(List<Integer> computer, List<Integer> input) {
        ball = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(input.get(i)) && !computer.get(i).equals(input.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public static int countingStrike(List<Integer> computer, List<Integer> input) {
        strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (Objects.equals(computer.get(i), input.get(i))) {
                strike++;
            }
        }
        return strike;
    }

}
