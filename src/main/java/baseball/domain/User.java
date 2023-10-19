package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private static final int NUMBER_LENGTH = 3;
    private final List<Integer> numbers = new ArrayList<>();

    public void setUserNumber(String number){
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            numbers.add(Integer.valueOf(number.charAt(i) - '0'));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
