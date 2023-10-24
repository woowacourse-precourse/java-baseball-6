package baseball.collaborator.number.generator;

import baseball.collaborator.number.generator.enums.BaseballNumbersGeneratorMessage;
import baseball.io.Input;
import baseball.io.Output;
import java.util.List;

public class BaseballNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = requestEnterNumbers();
        validation(numbers);
        return numbers;
    }

    private static List<Integer> requestEnterNumbers() {
        Output.console(BaseballNumbersGeneratorMessage.REQUEST_ENTER_NUMBERS.get());
        return Input.consoleNumbers();
    }

    private static void validation(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                    BaseballNumbersGeneratorMessage.ALERT_THREE_DIGIT_NUMBER.get());
        }
        if (numbers.stream().distinct().count() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                    BaseballNumbersGeneratorMessage.ALERT_DUPLICATE_INPUT_VALUES.get());
        }
        if (numbers.stream().anyMatch(number -> number.compareTo(0) < 0)) {
            throw new IllegalArgumentException(
                    BaseballNumbersGeneratorMessage.ALERT_NEGATIVE_NUMBER.get());
        }
    }

}
