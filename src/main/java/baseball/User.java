package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Integer> numbers;

    public User(String inputNumber) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            int number = inputNumber.charAt(i) - '0';
            numbers.add(number);
        }

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
