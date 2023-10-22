package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> numbers = new ArrayList<>();

    public void setNumbers(String input) {
        for(char c : input.toCharArray()) {
            numbers.add(c - '0');
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
