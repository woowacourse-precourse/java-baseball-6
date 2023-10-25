package baseball.util;

import baseball.model.Numbers;

public class NumbersConverter implements InputConverter {
    public static Numbers convert(String input) {
        try {
            int[] arr = new int[input.length()];
            for (int i = 0; i < arr.length; i++) {
                int n = input.charAt(i) - '0';
                arr[i] = n;
            }
            return Numbers.create(arr);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(ILLEGAL_INPUT_EXCEPTION_MESSAGE, e.getMessage(), input));
        }
    }
}
