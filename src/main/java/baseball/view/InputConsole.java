package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static baseball.domain.Message.*;

public class InputConsole {

    private InputConsole() {
    }

    public static List<Integer> readGameNumberList() {
        OutputConsole.print(INPUT.getMessage());
        String input = Console.readLine();
        InputValidation.convertNumberValidation(input);
        InputValidation.gameNumberRangeValidation(input);
        InputValidation.gameNumberContainZeroValidation(input);
        InputValidation.gameNumberDifferentDigitValidation(input);

        return intToList(Integer.parseInt(input));
    }

    public static int readEndOrStartNumber() {
        OutputConsole.println(END_OR_START.getMessage());
        String input = Console.readLine();
        InputValidation.convertNumberValidation(input);
        InputValidation.endOrStartNumberValidation(input);
        InputValidation.endOrStartNumberRangeValidation(input);

        return Integer.parseInt(input);
    }

    private static List<Integer> intToList(int number) {
        int hundredsDigit =  number / 100;
        int tensDigit = (number % 100) / 10;
        int onesDigit = number % 10;

        return Arrays.asList(hundredsDigit, tensDigit, onesDigit);
    }

    static class InputValidation {
        private static void convertNumberValidation(String input) {
            for (int i=0; i<input.length(); i++) {
                char checkData = input.charAt(i);
                if ('0' > checkData || checkData > '9') {
                    throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION.getMessage());
                }
            }
        }

        private static void gameNumberRangeValidation(String input) {
            if (input.length() != 3) {
                throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION.getMessage());
            }
        }

        private static void gameNumberContainZeroValidation(String input) {
            for (int i=0; i<input.length(); i++) {
                char checkData = input.charAt(i);
                if (checkData == '0') {
                    throw new IllegalArgumentException(OUT_OF_HINT_NUMBER_EXCEPTION.getMessage());
                }
            }
        }

        private static void gameNumberDifferentDigitValidation(String input) {
            char hundredsDigit =  input.charAt(0);
            char tensDigit = input.charAt(1);
            char onesDigit = input.charAt(2);

            if (hundredsDigit == tensDigit || tensDigit == onesDigit || hundredsDigit == onesDigit) {
                throw new IllegalArgumentException(DIFFERENT_DIGIT_EXCEPTION.getMessage());
            }
        }

        private static void endOrStartNumberRangeValidation(String input) {
            if (input.length() != 1) {
                throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION.getMessage());
            }
        }

        private static void endOrStartNumberValidation(String input) {
            int number = input.charAt(0) - '0';
            if (number != 1 && number != 2) {
                throw new IllegalArgumentException(END_OR_START_NUMBER_EXCEPTION.getMessage());
            }
        }
    }

}
