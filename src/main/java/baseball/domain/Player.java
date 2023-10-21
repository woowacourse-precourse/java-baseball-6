package baseball.domain;

import java.util.List;

public class Player {
    private final List<Integer> inputAnswer;

    public Player(List<Integer> inputAnswer) {
        this.inputAnswer = inputAnswer;
    }

    public List<Integer> getInputAnswer() {
        return inputAnswer;
    }
}