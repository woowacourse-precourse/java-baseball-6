package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProcessUserInput {

    List<Integer> answer;

    private ProcessUserInput(String input) {
        this.answer = processUserInput(input);
    }

    public static List<Integer> userAnswer(String input) {
        return new ProcessUserInput(input).getAnswer();
    }

    private List<Integer> processUserInput(String input) {
        validInput(input);
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    private void validInput(String input) {
        if (!isThreeDigitNumber(input) || hasDuplicateDigits(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isThreeDigitNumber(String input) {
        return input.length() == 3 && input.chars().allMatch(Character::isDigit);
    }

    private boolean hasDuplicateDigits(String input) {
        Set<Character> digits = new HashSet<>();
        for (char digit : input.toCharArray()) {
            if (!digits.add(digit)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
