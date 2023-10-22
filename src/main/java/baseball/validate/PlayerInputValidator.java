package baseball.validate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerInputValidator {
    public List<Integer> validateNumbers(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Input cannot be empty.");
        }
        input = input.replace(" ", "");
        String[] values = input.split("");

        checkLength(values);
        checkIfCharacter(values);
        checkDuplicate(values);

        return convertToList(values);
    }

    private void checkLength(String[] values) {
        if (values.length != 3) {
            throw new IllegalArgumentException("Error: Input must be 3 digits.");
        }
    }

    private void checkIfCharacter(String[] values) {
        for (String value : values) {
            if (!value.matches("[1-9]")) {
                throw new IllegalArgumentException("Error: Input should not contain any characters");
            }
        }
    }

    private void checkDuplicate(String[] values) {
        Set<String> uniqueValues = new HashSet<>();
        for (String value : values) {
            uniqueValues.add(value);
        }
        if (uniqueValues.size() != values.length) {
            throw new IllegalArgumentException("Error: Input should not contain duplicate numbers");
        }
    }

    private List<Integer> convertToList(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(Integer.parseInt(value));
        }
        return numbers;
    }
}
