package baseball;

import java.util.List;

public class Calculator {

    private static int STRIKE_NUMBER = 3;
    private static int LIST_TO = 3;
    private static int LIST_FROM = 0;
    private static int COUNTER_ZERO = 0;

    public static boolean isNotOver(int strike) {
        return strike != STRIKE_NUMBER;
    }

    public static int countStrike(List<Integer> input, List<Integer> answer) {
        int count = COUNTER_ZERO;

        for (int i = LIST_FROM; i < LIST_TO; i++) {
            if (input.get(i).equals(answer.get(i))) {
                count++;
            }
        }

        return count;
    }

    public static int countBall(List<Integer> input, List<Integer> answer) {
        int count = COUNTER_ZERO;

        for (int i = LIST_FROM; i < LIST_TO; i++) {
            if (!answer.contains(input.get(i))) {
                continue;
            }
            if (input.get(i).equals(answer.get(i))) {
                continue;
            }

            count++;
        }

        return count;
    }
}
