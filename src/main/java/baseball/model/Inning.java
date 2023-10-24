package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Inning {
    private final ArrayList<Integer> answer;
    private final ArrayList<Integer> input;
    private int strike;
    private int ball;

    public Inning(ArrayList<Integer> answer, ArrayList<Integer> input) {
        this.answer = answer;
        this.input = input;
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
    public String calculateResult() {
        setBallStrike();
        if (ball > 0 && strike > 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (ball > 0 && strike == 0) {
            return ball + "볼";
        }
        if (ball == 0 && strike > 0) {
            return strike + "스트라이크";
        }
        return "낫싱";
    }

    private void setBallStrike() {
        strike = checkSameNumberAndOrder();
        ball = checkSameNumber() - strike;
    }
}