package baseball;

import java.util.List;

public class Game {

    private static final int LIST_LEN = 3;

    public static boolean isNotOver(int strike) {
        return strike != LIST_LEN;
    }

    public static int countStrike(List<Integer> input, List<Integer> answer) {
        int count = 0;

        for (int idx = 0; idx < LIST_LEN; idx++) {

            if (input.get(idx).equals(answer.get(idx))) {
                count++;
            }
        }

        return count;
    }

    public static int countBall(List<Integer> input, List<Integer> answer) {
        int count = 0;

        for (int idx = 0; idx < LIST_LEN; idx++) {
            if (!answer.contains(input.get(idx))) {
                continue;
            }
            if (input.get(idx).equals(answer.get(idx))) {
                continue;
            }

            count++;
        }

        return count;
    }
}
