package baseball;

import java.util.List;

public class Answer {
    private final List<Integer> answerNumbers;

    Answer(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }

}
