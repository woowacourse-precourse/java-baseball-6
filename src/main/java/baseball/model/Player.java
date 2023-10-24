package baseball.model;

import baseball.util.NumericValidator;

import java.util.List;

public class Player {

    private List<Integer> playerNumbers;
    private NumericValidator validator;

    public Player() {
        this.validator = new NumericValidator();
    }

    public List<Integer> getPlayerNumbers(String inputNumber) {
        this.playerNumbers = validator.validate(inputNumber);
        return playerNumbers;
    }
}
