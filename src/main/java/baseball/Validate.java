package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validate {
    public static final Integer BASEBALL_NUM_OF_DIGITS = 3;
    public static final Integer BASEBALL_START_DIGITS = 1;
    public static final Integer BASEBALL_END_DIGITS = 9;
    public static final Integer CONTINUE_NUM_OF_DIGITS = 1;
    public static final Integer[] CONTINUE_RANGE_OF_DIGITS = {1, 2};

    public static void validateContinueGame(String number) throws IllegalArgumentException {
        if (number.length() != CONTINUE_NUM_OF_DIGITS) {
            throw new IllegalArgumentException();
        }
        if (!Arrays.stream(CONTINUE_RANGE_OF_DIGITS).toList().contains(Integer.parseInt(number))) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumber(String number) throws IllegalArgumentException {
        if (number.length() != BASEBALL_NUM_OF_DIGITS) {
            throw new IllegalArgumentException();
        }
        int num;
        Set<Integer> distinctNumber = new HashSet<>();
        for (int i = 0; i < BASEBALL_NUM_OF_DIGITS; i++) {
            num = Character.getNumericValue(number.charAt(i));
            if (BASEBALL_START_DIGITS > num || num > BASEBALL_END_DIGITS) {
                throw new IllegalArgumentException();
            }
            distinctNumber.add(num);
        }
        if (distinctNumber.size() < BASEBALL_NUM_OF_DIGITS) {
            throw new IllegalArgumentException();
        }
    }
}
