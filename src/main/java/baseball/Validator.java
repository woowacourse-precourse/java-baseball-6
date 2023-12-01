package baseball;

import java.util.List;

public class Validator {
    public static void validateNumber(String player) {
        try {
            validateIntConvertable(player);
            int number = Integer.parseInt(player);
            validateRange(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    static void validateRange(int number) {
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException();
        }
    }

    static void validateIntConvertable(String player) {
        try {
            Integer.parseInt(player);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    static void duplicated(Integer[] numbers) {
        for (int i=1; i<numbers.length; i++) {
            if (numbers[i] == numbers[i-1]) {
                throw new IllegalArgumentException();
            }
        }
    }
}
