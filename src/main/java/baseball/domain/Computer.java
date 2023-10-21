package baseball.domain;

import java.util.List;

public class Computer {

    private List<Integer> answerNumberList;

    public Computer(List<Integer> answerNumber) {
        this.answerNumberList = answerNumber;
    }

    public List<Integer> getAnswerNumberList() {
        return answerNumberList;
    }
}
