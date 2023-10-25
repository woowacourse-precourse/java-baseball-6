package baseball.domain;

public class User {
    private final Numbers numbers;

    public User(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
