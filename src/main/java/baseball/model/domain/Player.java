package baseball.model.domain;

import baseball.model.service.PlayerNumbersValidator;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNumbers;
    private PlayerNumbersValidator playerNumbersValidator;

    private Player(String inputNumbers, PlayerNumbersValidator playerNumbersValidator) {
        this.playerNumbersValidator = playerNumbersValidator;
        playerNumbersValidator.validatePlayerNumbers(inputNumbers);
        this.playerNumbers = parsePlayerNumbers(inputNumbers);
    }

    public static Player of(String inputNumbers, PlayerNumbersValidator playerNumbersValidator) {
        return new Player(inputNumbers, playerNumbersValidator);
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    private List<Integer> parsePlayerNumbers(String inputNumbers) {
        List<Integer> playerNumbers = new ArrayList<>();
        for (int i = 0; i < inputNumbers.length(); i++) {
            int num = Character.getNumericValue(inputNumbers.charAt(i));
            playerNumbers.add(num);
        }
        return playerNumbers;
    }
}
