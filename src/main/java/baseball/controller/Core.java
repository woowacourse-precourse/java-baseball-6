package baseball.controller;

import baseball.model.Result;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Core {

    final int LIST_LEN = 3;

    Generator generator = new Generator();
    View view = new View();
    Validation validation = new Validation();

    public void run() {
        List<Integer> answer = generator.generateAnswer(LIST_LEN);
        boolean playing = true;

        while (playing) {
            view.askNumber();

            String listInput = Console.readLine();
            validation.validateInputList(listInput, LIST_LEN);

            List<Integer> inputList = generator.generateInputList(listInput);

            Result result = makeResult(inputList, answer);

            view.showResult(result);

            playing = isNotOver(result.getStrike());
        }
    }

    public boolean isNotOver(int strike) {
        return strike != LIST_LEN;
    }

    public Result makeResult(List<Integer> input, List<Integer> answer) {
        int strike = countStrike(input, answer);
        int ball = countBall(input, answer);

        return new Result(strike, ball);
    }

    public int countStrike(List<Integer> input, List<Integer> answer) {
        int count = 0;

        for (int idx = 0; idx < LIST_LEN; idx++) {

            if (input.get(idx).equals(answer.get(idx))) {
                count++;
            }
        }

        return count;
    }

    public int countBall(List<Integer> input, List<Integer> answer) {
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
