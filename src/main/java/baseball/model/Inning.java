package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Inning {
    private final ArrayList<Integer> answer;
    private final ArrayList<Integer> input;
    private final int strike;
    private final int ball;

    public Inning(ArrayList<Integer> answer, ArrayList<Integer> input) {
        this.answer = answer;
        this.input = input;
        this.strike = checkSameNumberAndOrder();
        this.ball = checkSameNumber() - strike;
    }


    private int checkSameNumber() {
        List<Integer> answerList = new ArrayList<>(answer);
        List<Integer> inputList = new ArrayList<>(input);
        answerList.retainAll(inputList);
        return answerList.size();
    }

    private int checkSameNumberAndOrder() {
        int count = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(input.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
