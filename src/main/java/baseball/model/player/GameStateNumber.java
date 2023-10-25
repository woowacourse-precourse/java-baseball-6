package baseball.model.player;

import static baseball.exception.GameStateNumberValidator.isGameStateNumberValid;

import camp.nextstep.edu.missionutils.Console;

public class GameStateNumber {

    private static final Integer START = 1;
    private static final Integer EXIT = 2;

    private Integer stateNumber;

    public GameStateNumber() {
        this.stateNumber = START;
    }

    public void input() {
        String input = Console.readLine();
        validateGameStateNumber(input);
        this.stateNumber = Integer.parseInt(input);
    }

    private void validateGameStateNumber(String input) {
        if (!isGameStateNumberValid(input)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isExit() {
        if (this.stateNumber == EXIT) {
            return true;
        }
        return false;
    }
}
