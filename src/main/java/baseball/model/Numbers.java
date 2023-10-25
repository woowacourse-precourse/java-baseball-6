package baseball.model;

import java.util.List;

public class Numbers {
    private List<Integer> savedNumbers;

    public Numbers() {
    }

    public Numbers(List<Integer> inputNumbers) {
        savedNumbers = inputNumbers;
    }

    public static Numbers from(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    public Integer valueAt(int index) {
        return savedNumbers.get(index);
    }

    public Boolean equalsAt(Integer number, int index) {
        return savedNumbers.get(index).equals(number);
    }

    public Boolean contains(Integer number) {
        return savedNumbers.contains(number);
    }
}
