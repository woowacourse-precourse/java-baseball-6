package baseball.view;

import baseball.domain.GameCommand;
import baseball.global.exception.CustomException;
import baseball.global.exception.ErrorMessage;
import baseball.global.validator.Validator;
import baseball.view.console.ConsoleReader;
import baseball.view.console.ConsoleWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<Integer> enterNumbers() {
        ConsoleWriter.printMessage("숫자를 입력해주세요 : ");
        return validateNumbers(ConsoleReader.enterMessage());
    }

    private List<Integer> validateNumbers(String message) {
        validateLength(message);
        List<String> numbers = parseStringToList(message, "");
        validateDuplicated(numbers);
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            int value = Validator.validateNumber(number);
            Validator.validateRange(value, 1, 9);
            result.add(value);
        }
        return result;
    }

    private void validateLength(String message) {
        if (message.length() != 3) {
            throw CustomException.from(ErrorMessage.INVALID_NUMBER_ERROR);
        }
    }

    private static List<String> parseStringToList(String message, String separator) {
        return Arrays.stream(split(message, separator)).toList();
    }

    private static String[] split(String message, String separator) {
        return message.split(separator);
    }

    private static void validateDuplicated(List<String> items) {
        if (hasDuplicatedItem(items)) {
            throw CustomException.from(ErrorMessage.INVALID_NUMBER_ERROR);
        }
    }

    private static boolean hasDuplicatedItem(List<String> items) {
        return items.size() != calculateUniqueItemsCount(items);
    }

    private static int calculateUniqueItemsCount(List<String> items) {
        return (int) items.stream()
                .distinct()
                .count();
    }

    public GameCommand enterRestartOrQuit() {
        ConsoleWriter.printlnMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return GameCommand.from(ConsoleReader.enterMessage());
    }
}
