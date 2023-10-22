package baseball.model;

import baseball.util.NumberGenerator;
import java.util.List;

public class Computer {
    private List<Integer> answer;

    public void generateNumber() {
        NumberGenerator numberGenerator = new NumberGenerator();
        this.answer = numberGenerator.getGeneratedNumbers();
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
