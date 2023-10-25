package baseball.model.domain;

import baseball.model.service.Validator;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private final List<Integer> playerNumbers;

    private Player(String inputNumbers, Validator validator) {
        validator.validatePlayerNumbers(inputNumbers);
        this.playerNumbers = parse(inputNumbers);
    }

    public static Player of(String inputNumbers, Validator validator) {
        return new Player(inputNumbers, validator);
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    private List<Integer> parse(String inputNumbers) {
        return inputNumbers.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
    }
}
