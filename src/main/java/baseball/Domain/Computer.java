package baseball.Domain;

import baseball.Util.AnswerNumberGenerator;
import java.util.List;

public class Computer {

    private final AnswerNumberGenerator answerNumberGenerator;
    private List<Integer> answerNumber;

    public Computer() {
        answerNumberGenerator = new AnswerNumberGenerator();
    }

    public List<Integer> getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(List<Integer> answerNumber) {
        this.answerNumber = answerNumberGenerator.generateAnswerNumber();
    }
}
