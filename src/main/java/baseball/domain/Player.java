package baseball.domain;

import java.util.List;

public class Player {

    private Numbers numbers;

    public void chooseNumbers(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }
}
