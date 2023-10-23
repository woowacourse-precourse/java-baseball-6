package baseball.model;

import static baseball.util.InputValidator.isRestartOrExitValid;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Player {

    private GuessNumber guessNumber;
    private Integer restartOrExit;

    public Player() {
        this.guessNumber = new GuessNumber();
        this.restartOrExit = null;
    }

    public void inputNumbers() {
        guessNumber.guess();
    }

    public void inputRestartOrExit() {
        String input = Console.readLine();
        validateInputRestartOrExit(input);
        this.restartOrExit = Integer.parseInt(input);
    }

    private void validateInputRestartOrExit(String input) {
        if (!isRestartOrExitValid(input)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return guessNumber.getNumbers();
    }

    public Integer getRestartOrExit() {
        return restartOrExit;
    }
}
