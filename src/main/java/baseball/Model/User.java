package baseball.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static final int FIRST_INDEX = 0;
    public static final int LAST_INDEX = 2;
    private Numbers numbers;

    public User(List<Integer> convertedInput) {
        this.numbers = new Numbers(convertedInput);
    }

    public Numbers getNumbers() {
        return numbers;
    }

}
