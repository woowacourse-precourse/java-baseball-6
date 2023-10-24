package baseball.model.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private final PlayerValidator playerValidator = new PlayerValidator();
    private List<Integer> expectedNumbers;

    public void updateExpectedNumbers(String numbers) {
        initExpectedNumbers();
        playerValidator.validateExpectedNumbers(numbers);
        expectedNumbers = toList(numbers);
    }

    private void initExpectedNumbers() {
        expectedNumbers = new ArrayList<>();
    }

    private List<Integer> toList(String numbers) {
        return numbers.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }

    public List<Integer> getExpectedNumbers() {
        return Collections.unmodifiableList(expectedNumbers);
    }
}
