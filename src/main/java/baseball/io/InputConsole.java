package baseball.io;

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
        static void convertNumberValidation(String input) {
            for (int i=0; i<input.length(); i++) {
                int checkData = input.charAt(i) - '0';
                if (0 > checkData || checkData > 9) {
                    throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다.");
                }
            }
        }

        static void gameNumberRangeValidation(String input) {
            if (input.length() != 3) {
                throw new IllegalArgumentException("입력된 숫자가 범위를 초과하였습니다.");
            }
        }

        static void gameNumberContainZeroValidation(String input) {
            for (int i=0; i<input.length(); i++) {
                char checkData = input.charAt(i);
                if (checkData == '0') {
                    throw new IllegalArgumentException("입력된 숫자는 1~9까지만 가능합니다. (0은 입력할 수 없습니다)");
                }
            }
        }

        static void gameNumberDifferentDigitValidation(String input) {
            int hundredsDigit =  input.charAt(0) - '0';
            int tensDigit = input.charAt(1) - '0';
            int onesDigit = input.charAt(2) - '0';

            if (hundredsDigit == tensDigit || tensDigit == onesDigit || hundredsDigit == onesDigit) {
                throw new IllegalArgumentException("입력된 숫자는 서로 다른 3자리의 수여야 합니다.");
            }

        }

        private static void endOrStartNumberRangeValidation(String input) {
            if (input.length() != 1) {
                throw new IllegalArgumentException("입력된 숫자가 범위를 초과하였습니다.");
            }
        }

        private static void endOrStartNumberValidation(String input) {
            int number = input.charAt(0) - '0';
            if (input.length() != 1 && number != 1 && number != 2) {
                throw new IllegalArgumentException("재시작/종료 입력값은 1과 2중 하나의 수여야 합니다.");
            }
        }
    }

}
