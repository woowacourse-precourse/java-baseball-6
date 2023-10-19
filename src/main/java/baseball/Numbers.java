package baseball;

import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(final List<Integer> numbers) {
        return new Numbers(numbers);
    }
}
