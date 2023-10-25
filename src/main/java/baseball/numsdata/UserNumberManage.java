package baseball.numsdata;

import java.util.ArrayList;
import java.util.List;

public class UserNumberManage {
    private static final int MAX_LENGTH = 3;
    private List<Integer> numbers;

    public void checkNumber(String data) {
        numbers = new ArrayList<>();

        if (data.length() != MAX_LENGTH) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < MAX_LENGTH; i++) {
            if (!Character.isDigit(data.charAt(i))) {
                throw new IllegalArgumentException();
            }
            int num = Character.getNumericValue(data.charAt(i));
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException();
            }
            if (numbers.contains(num)) {
                throw new IllegalArgumentException();
            } else {
                numbers.add((num));
            }

        }
    }

    public List<Integer> getUserNumbers() {
        return numbers;
    }
}
