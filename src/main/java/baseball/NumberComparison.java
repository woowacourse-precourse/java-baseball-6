package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NumberComparison {
    private static final int ANSWER_LENGTH = 3;
    private final List<Integer> randomNumberList;

    public NumberComparison(List<Integer> randomNumberList) {
        this.randomNumberList = randomNumberList;
    }

    public List<Integer> compareList(List<Integer> userInputList) {
        int strike = (int) IntStream.range(0, ANSWER_LENGTH)
                .filter(i -> randomNumberList.get(i).equals(userInputList.get(i)))
                .count();

        int ball = (int) IntStream.range(0, ANSWER_LENGTH)
                .filter(i -> randomNumberList.contains(userInputList.get(i)))
                .count() - strike;

        List<Integer> answerList = new ArrayList<>();
        answerList.add(ball);
        answerList.add(strike);
        return answerList;
    }

    public boolean success(List<Integer> result) {
        if (result.get(1) == 3) {
            return false;
        }
        return true;
    }
}
