package baseball.domain;

import baseball.util.InputValidator;
import baseball.util.Parser;

import java.util.List;

public class Player {

    private List<Integer> playerNumbers;

    public void setPlayerNumbers(String inputNumber) {
        validateInputNumber(inputNumber);
        playerNumbers = Parser.parseStringToListOfInteger(inputNumber);
    }

    private void validateInputNumber(String inputNumber) {
        InputValidator.validatePlayerInputNumber(inputNumber);
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}
