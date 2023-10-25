package baseball.games.numberbaseball.util;

import baseball.games.numberbaseball.enums.PlayerOption;
import baseball.games.numberbaseball.validation.BaseballValidator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGenerator {
    private final BaseballValidator validator = new BaseballValidator();

    public List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public List<Integer> createValidatedNumbers(String playerNumbers) {
        validator.validateNumbersInput(playerNumbers);
        return playerNumbers.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    public PlayerOption createValidatedOption(String playerOption) {
        validator.validateOptionInput(playerOption);
        if (playerOption.charAt(0) == '1') {
            return PlayerOption.RESTART;
        }
        return PlayerOption.END;
    }
}
