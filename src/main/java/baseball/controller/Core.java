package baseball.controller;

import baseball.Configuration;
import baseball.view.View;
import java.util.List;

public class Core {

    int LIST_LEN = Configuration.LIST_LEN;

    Generator generator = new Generator();
    View view = new View();

    public void run() {
        List<Integer> answer = generator.generateAnswer(LIST_LEN);
        boolean playing = true;

        while (playing) {
            view.askNumber();

            List<Integer> inputList = generator.generateInputList();

            int strike = countStrike(inputList, answer);
            int ball = countBall(inputList, answer);

            view.showResult(strike, ball);

            playing = isNotOver(strike);
        }
    }

    public boolean isNotOver(int strike) {
        return strike != LIST_LEN;
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
