package baseball.Exception;

import java.util.List;

public class ExceptionHandler {

    public ExceptionHandler() {
    }

    public static void checkException(List<Integer> input) {

        checkNotNumber(input);
        checkDigit(input);
        checkDuplication(input);
    }

    private static void checkDigit(List<Integer> input) {

        if (input.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNotNumber(List<Integer> input) {

        for (Integer num : input) {
            try {
                Integer.parseInt(String.valueOf(num));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void checkDuplication(List<Integer> input) {

        for (int i = 0; i < 3; i++) {

            for (int j = i + 1; j < 2; j++) {

                isDuplicate(input.get(i), input.get(j));
            }
        }
    }

    private static void isDuplicate(Integer num1, Integer num2) {

        if (num1.equals(num2)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkRestartNum(List<Integer> input) {

    }
}
