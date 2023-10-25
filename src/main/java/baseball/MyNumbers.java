package baseball;

import java.util.ArrayList;
import java.util.List;

public class MyNumbers {
    private final static int MAX_LENGTH = 3;
    private final List<Integer> nums = new ArrayList<>();
    private final int length;

    private boolean isDuplicated(Integer num) {
        return nums.contains(num);
    }

    MyNumbers(String input) {
        length = input.length();
        if (length != MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < input.length(); i++) {
            try {
                Integer num = Integer.parseInt(String.valueOf(input.charAt(i)));

                if (isDuplicated(num)) {
                    throw new IllegalArgumentException();
                }
                nums.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNums() {
        return nums;
    }
}
