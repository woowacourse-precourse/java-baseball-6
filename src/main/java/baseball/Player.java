package baseball;

import java.util.Arrays;
import java.util.List;

public class Player {

    private static final int NUMBER_SIZE = 3;
    private static final String NUMBER_SIZE_EXCEPTION = "%d자리 수만 가능합니다.";

    private List<Integer> numbers;

    public Player(String number) {
        validateNumberSize(number);
        this.numbers = convert(number);
    }

    private void validateNumberSize(String number) {
        if (number.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format(NUMBER_SIZE_EXCEPTION, NUMBER_SIZE));
        }
    }

    private List<Integer> convert(String number) {
        return Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
