package baseball;

import java.util.List;

public class Calculator {

    public static int countStrike(List<Integer> input, List<Integer> answer) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (input.get(i).equals(answer.get(i))) {
                count++;
            }
        }

        return count;
    }

    public static int countBall(List<Integer> input, List<Integer> answer) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
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
