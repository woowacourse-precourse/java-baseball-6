package baseball.controller;

import baseball.model.Result;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Core {

    private static final int LIST_LEN = 3;

    public static void run() {
        List<Integer> answer = Generator.generateAnswer(LIST_LEN);
        boolean playing = true;

        while (playing) {
            View.askNumber();

            String input = Console.readLine();
            Validation.validateNumberString(input, LIST_LEN);

            List<Integer> inputList = Generator.generateNumericInputList(input);

            Result result = makeResult(inputList, answer);
            View.showResult(result);

            playing = isNotOver(result.getStrike());
        }
    }

    public static boolean isNotOver(int strike) {
        return strike != LIST_LEN;
    }

    public static Result makeResult(List<Integer> input, List<Integer> answer) {
        int strike = countStrike(input, answer);
        int ball = countBall(input, answer);

        return new Result(strike, ball);
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
