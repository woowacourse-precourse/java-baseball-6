package baseball.model;

import java.util.List;

public class Computer {
    private static final int NUMBERS_SIZE = 3;

    private final List<Integer> numbers;

    public Computer(List<Integer> numbers) {
        validateNumberSize(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers){
        if(numbers.size() != NUMBERS_SIZE){
            throw new IllegalArgumentException("숫자는 3개를 가져야 합니다");
        }
    }
}
