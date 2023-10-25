package baseball.model;

import java.util.List;

public class User {
    private List<Integer> numbers;
    public User() {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "User{" +
                "numbers=" + numbers +
                '}';
    }
}
