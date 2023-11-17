package baseball.domain;

import java.util.List;

import static baseball.service.NumberGenerator.*;

public class Game {
    private final List<Integer> computerAnswer;
    private List<Integer> userAnswer;

    private boolean isUserWin = false;

    public Game() {
        this.computerAnswer = pickNumbersInRangeWithoutDuplicates(1,9, 3);
    }

    public Result makeResult() {
        return null;
    }

    public List<Integer> getComputerAnswer() {
        return computerAnswer;
    }

    public List<Integer> getUserAnswer() {
        return userAnswer;
    }

    public boolean isUserWin() {
        return isUserWin;
    }

    public void setUserAnswer(List<Integer> userAnswer) {
        this.userAnswer = userAnswer;
    }
}
