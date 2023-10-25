package baseball.Model;

import java.util.Arrays;

public class UserNumber {
    private String number;

    private static int NUMBER_RANGE_START = 1;
    private static int NUMBER_RANGE_END = 9;

    public UserNumber(String number) {
        validate(number);
        this.number = removeSpace(number);
    }

    private String removeSpace(String number) { // 공백 제거
        return number.replaceAll(" ", null);
    }

    public String getNumber() {
        return number;
    }

    private void validate(String number) {

        if (isEmpty(number)) {
            throw new IllegalArgumentException();
        }

        if (!isSizeThree(number)) {
            throw new IllegalArgumentException();
        }

        if (!isDigit(number)) {
            throw new IllegalArgumentException();
        }

        if (!isBetweenOneAndNine(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isBetweenOneAndNine(String number) {
        String[] arr = number.split("");

        return Arrays.stream(arr).allMatch(
                value -> Integer.valueOf(value) >= NUMBER_RANGE_START && Integer.valueOf(value) <= NUMBER_RANGE_END
        );
    }

    private boolean isDigit(String number) {
        String[] arr = number.split("");
        return Arrays.stream(arr).allMatch(value -> Character.isDigit(value.charAt(0)));
    }

    private boolean isEmpty(String number) {
        return number.isBlank() || number == null;
    }

    private boolean isSizeThree(String number) {
        return number.length() == 3;
    }
}
