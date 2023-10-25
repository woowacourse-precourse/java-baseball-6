package baseball.view;


import java.util.List;

public class ConsoleValidator {

    private static final IllegalArgumentException ILLEGAL_ARGUMENT_EXCEPTION = new IllegalArgumentException();
    private static final String NUMBER_REGEX = "[1-9]+";
    private static final List<String> RESTART_OR_TERMINATE_OPTION = List.of("1", "2");


    public static void validateInputNotNull(String inputString) {

        if (inputString == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputNotBlank(String inputString) {

        if (inputString.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputIsNumber(String inputString) {

        if (!inputString.matches(NUMBER_REGEX)) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    public static void validateInput3DigitNumber(String inputString) {

        if (inputString.length() != 3) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    public static void validateInputNotDuplicate(String inputString) {

        int[] appearance = new int[10];

        for (char inputChar : inputString.toCharArray()) {
            appearance[inputChar - '0']++;
        }

        for (int appeared : appearance) {
            if (appeared >= 2) {
                throw ILLEGAL_ARGUMENT_EXCEPTION;
            }
        }

    }

    public static void validateRestartOrTerminate(String inputString) {
        if (!RESTART_OR_TERMINATE_OPTION.contains(inputString)) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }
}
