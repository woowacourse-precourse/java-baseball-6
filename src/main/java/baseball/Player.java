package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public String inputNumber(final int numberLength) {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        validateNumber(number);
        validateNumberLength(number, numberLength);
        return number;
    }

    private void validateNumber(final String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("number cannot be empty");
        }
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("number cannot contain any letters");
        }
    }

    private void validateNumberLength(final String number, final int numLength) {
        if (!isValidLength(number, numLength)) {
            throw new IllegalArgumentException(
                "number Length is different from the system setting");
        }
    }

    private boolean isValidLength(final String number, int numLength) {
        return number.length() == numLength;
    }

    private boolean isValidNumber(final String number) {
        return number
            .chars()
            .allMatch(c -> Character.isDigit(c) && c >= '1' && c <= '9');
    }
}
