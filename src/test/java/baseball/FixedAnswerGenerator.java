package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class FixedAnswerGenerator implements AnswerGenerator {
    @Override
    public List<Integer> generate() {
        return List.of(1, 2, 3);
    }

    public List<Integer> generate(String input) {
        String validatedInput = InputValidator.validateBaseBallNumber(input);
        return validatedInput.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
