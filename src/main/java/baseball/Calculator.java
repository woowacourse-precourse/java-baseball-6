package baseball;

import java.util.List;

public class Calculator {

    public static int countStrike(List<Integer> input, List<Integer> answer) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (input.get(0).equals(answer.get(0))) {
                count++;
            }
        }

        return count;
    }
}
