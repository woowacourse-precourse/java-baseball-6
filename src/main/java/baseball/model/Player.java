package baseball.model;

import java.util.List;

public class Player {

    private GuessNumber guessNumber;
    private RestartOrExit restartOrExit;

    public Player() {
        this.guessNumber = new GuessNumber();
        this.restartOrExit = RestartOrExit.NONE;
    }

    public void inputNumbers() {
        guessNumber.guess();
    }

    public void inputRestartOrExit() {
        restartOrExit.input();
    }

    public List<Integer> getNumbers() {
        return guessNumber.getNumbers();
    }

    public Integer getRestartOrExit() {
        return restartOrExit.getRestartOrExit();
    }
}
