package baseball.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class BaseBall {
    static final int DIGITS = 3;
    private final int[] digits;

    static BaseBall getInstance(int number) {
        return new BaseBall(number);
    }

    private BaseBall(int number) {
        validateNumber(number);
        String numberString = String.valueOf(number);
        char[] digits = numberString.toCharArray();
        this.digits = new int[DIGITS];
        for (int i = 0; i < DIGITS; i++) {
            this.digits[i] = Character.getNumericValue(digits[i]);
        }
    }

    private void validateNumber(int number) {
        if (checkOneToNine(number) || checkDigits(number) || checkDuplicate(number)) {
            throw new IllegalArgumentException("야구 숫자가 될 수 없는 숫자 입니다!");
        }
    }

    private boolean checkOneToNine(int number) {
        String numberString = String.valueOf(number);
        Pattern regex = Pattern.compile("^[1-9]+$");
        Matcher oneToNineMatcher = regex.matcher(numberString);
        return !oneToNineMatcher.matches();
    }

    private boolean checkDigits(int number) {
        String numberString = String.valueOf(number);
        return numberString.length() != DIGITS;
    }

    private boolean checkDuplicate(int number) {
        String numberString = String.valueOf(number);
        long countWithOutDuplicate = Arrays.stream(numberString.split(""))
                .distinct()
                .count();
        return numberString.length() > countWithOutDuplicate;
    }
}
