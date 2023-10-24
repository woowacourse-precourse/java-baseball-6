package baseball.model.domain;

import baseball.model.service.PlayerNumbersValidator;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> playerNumbers;
    private PlayerNumbersValidator playerNumbersValidator;

    private Player(String inputNumbers, PlayerNumbersValidator playerNumbersValidator) {
        this.playerNumbersValidator = playerNumbersValidator;
        playerNumbersValidator.validatePlayerNumbers(inputNumbers);
        this.playerNumbers = parse(inputNumbers);
    }

    public static Player of(String inputNumbers, PlayerNumbersValidator playerNumbersValidator) {
        return new Player(inputNumbers, playerNumbersValidator);
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    private List<Integer> parse(String inputNumbers) {
        return inputNumbers.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
    }
}
