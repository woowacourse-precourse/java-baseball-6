package baseball.domain;

import java.util.List;

public class RandomNumber {

    private List<Integer> randomNumber;

    public static RandomNumber create(List<Integer> numbers) {
        return new RandomNumber(numbers);
    }

    private RandomNumber(List<Integer> numbers) {
        this.randomNumber = numbers;
    }

    public boolean numberExistsInList(Integer numberAtIndex) {
        return randomNumber.contains(numberAtIndex);
    }

    public Integer getNumberAtIndex(int index) {
        return this.randomNumber.get(index);
    }

    public void reset(List<Integer> numbers) {
        this.randomNumber = numbers;
    }
}
