package baseball.domain;

import baseball.util.AnswerCreator;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerAnswer = new ArrayList<>();
    private static final AnswerCreator answerCreator = new AnswerCreator();

    public List<Integer> getComputerAnswer() {
        return computerAnswer;
    }

    public void setComputerAnswer() {
        computerAnswer = answerCreator.createAnswer();
    }

}
