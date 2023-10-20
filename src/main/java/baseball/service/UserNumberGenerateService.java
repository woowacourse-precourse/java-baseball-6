package baseball.service;

import baseball.model.UserNumber;

import java.util.Arrays;

public class UserNumberGenerateService {
    public int[] generateUserNumber(String input) {
        isRightFormatNumber(input);
        isOverLengthNumber(input);
        isDuplicatedNumber(input);
        isContainedZero(input);


        return new UserNumber(stringToIntegerList(input)).getNumber();

    }

    private int[] stringToIntegerList(String input) {
        return Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
    }

    private void isDuplicatedNumber(String input) {
        long count = input.chars().distinct().count();
        if (count != 3) {
            System.out.println("중복된 숫자가 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void isRightFormatNumber(String input) {
        if (!input.matches("\\d+")) {
            System.out.println("숫자가 아닌 값이 포함 되어 있습니다.");
            throw new IllegalArgumentException();
        }

    }

    private void isContainedZero(String input) {
        if (input.contains("0")) {
            System.out.println("0이 포함되어 있습니다.");
            throw new IllegalArgumentException();
        }

    }

    private void isOverLengthNumber(String input) {
        if (input.length() != 3) {
            System.out.println("숫자는 3개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}

