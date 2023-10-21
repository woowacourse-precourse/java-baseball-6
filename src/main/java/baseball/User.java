package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> numbers;

    public User() {
        // TODO: 입력된 Numbers 예외 처리

        setNumbers(Input.readUserNumbers());
    }

    private void setNumbers(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < inputNumbers.length(); i++) {
            int number = inputNumbers.charAt(i) - '0';
            numbers.add(number);
        }

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
