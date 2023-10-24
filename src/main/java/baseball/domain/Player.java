package baseball.domain;

import baseball.util.InputValidator;
import baseball.util.Parser;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNumbers = new ArrayList<>();

    public void setPlayerNumbers(String inputNumber) {
        InputValidator.validatePlayerInputNumber(inputNumber);
        playerNumbers = Parser.parseStringToListOfInteger(inputNumber);
    }
}
