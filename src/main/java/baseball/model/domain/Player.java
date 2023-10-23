package baseball.model.domain;

import baseball.model.service.PlayerNumbersValidator;
import baseball.model.service.PlayerNumbersValidatorImp;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNumbers;

    public Player(String inputNumbers) {
        PlayerNumbersValidator playerNumbersValidator = new PlayerNumbersValidatorImp();
        playerNumbersValidator.isNonNumber(inputNumbers);

        List<Integer> convertNumbers = convertNumbers(inputNumbers);
        playerNumbersValidator.isLengthCorrect(convertNumbers);
        playerNumbersValidator.isRange(convertNumbers);
        playerNumbersValidator.isDuplicate(convertNumbers);
        this.playerNumbers = convertNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public List<Integer> convertNumbers(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputNumbers.length(); i++) {
            char ch = inputNumbers.charAt(i);
            int num = Character.getNumericValue(ch);
            numbers.add(num);
        }
        return numbers;
    }
}
