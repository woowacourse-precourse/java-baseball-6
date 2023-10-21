package baseball.controller;

import baseball.Configuration;
import baseball.view.View;
import java.util.List;

public class Core {

    private static final int LIST_LEN = Configuration.LIST_LEN;

    public static void run() {
        List<Integer> answer = Generator.generateAnswer(LIST_LEN);
        boolean playing = true;

        while (playing) {
            View.askNumber();

            List<Integer> inputList = Generator.generateInputList();

            int strike = Core.countStrike(inputList, answer);
            int ball = Core.countBall(inputList, answer);

            View.showResult(strike, ball);

            playing = Core.isNotOver(strike);
        }
    }

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
