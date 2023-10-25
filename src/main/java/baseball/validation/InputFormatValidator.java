package baseball.validation;

import static baseball.configuration.RandomNumberConfig.COUNT;
import static baseball.constant.ErrorMessage.BASEBALL_NUMBERS_INPUT_EXCEPTION;
import static baseball.constant.ErrorMessage.CHOICE_NUMBER_INPUT_EXCEPTION;

public class InputFormatValidator {

    public static void validateBaseballNumbers(String inputNumbers) {
        if (inputNumbers.matches("^\\d{" + COUNT + "}$") && validateNotDuplicatedNumbers(inputNumbers)) {
            return;
        }

        throw new IllegalArgumentException(BASEBALL_NUMBERS_INPUT_EXCEPTION);
    }

    public static void validateChoiceNumber(String choiceOfRestart) {
        if (choiceOfRestart.equals("1") || choiceOfRestart.equals("2")) {
            return;
        }

        throw new IllegalArgumentException(CHOICE_NUMBER_INPUT_EXCEPTION);
    }

    private static boolean validateNotDuplicatedNumbers(String inputNumbers) {

        for (int i = 0; i < inputNumbers.length() - 1; i++) {
            for (int j = i + 1; j < inputNumbers.length(); j++) {
                if (inputNumbers.charAt(i) == inputNumbers.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

}
