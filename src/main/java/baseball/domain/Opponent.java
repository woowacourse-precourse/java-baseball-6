package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Opponent {

    private List<Integer> answerNumbers;

    public Opponent() {
        answerNumbers = new ArrayList<>();
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }
}
