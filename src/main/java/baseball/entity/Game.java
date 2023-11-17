package baseball.entity;

import java.util.List;

public class Game {
    private final List<Integer> computerAnswer;
    private List<Integer> userAnswer;

    public Game(List<Integer> computerAnswer) {
        this.computerAnswer = computerAnswer;
    }

    public List<Integer> getComputerAnswer() {
        return computerAnswer;
    }

    public List<Integer> getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(List<Integer> userAnswer) {
        this.userAnswer = userAnswer;
    }
}
