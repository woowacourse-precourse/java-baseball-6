package baseball.model;


import static baseball.model.GameNumber.NUM_LENGTH;

import java.util.List;

public class BaseballService {
    public static void getResult(List<Integer> input, List<Integer> answer) {
        for (int i = 0; i < NUM_LENGTH; i++) {
            if (input.contains(answer.get(i))) {
                countScore(input.get(i), answer.get(i));
            }
        }
    }

    public static void countScore(int inputNum, int answerNum) {
        if (inputNum == answerNum) {
            Result.countStrike();
        } else {
            Result.countball();
        }
    }

}
