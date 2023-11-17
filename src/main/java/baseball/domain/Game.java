package baseball.domain;

import java.util.List;

import static baseball.service.NumberGenerator.*;

public class Game {
    private final List<Integer> computerNumbers;
    private List<Integer> userNumbers;

    private boolean isUserWin = false;

    public Game() {
        this.computerNumbers = pickNumbersInRangeWithoutDuplicates(1,9, 3);
    }

    public Result makeResult() {
        return null;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public boolean isUserWin() {
        return isUserWin;
    }

    public void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }
}
