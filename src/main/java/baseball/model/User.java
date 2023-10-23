package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> numbers;

    public void setNumbers(String input) {
        numbers = new ArrayList<>();
        for(char c : input.toCharArray()) {
            numbers.add(c - '0');
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
