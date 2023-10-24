package baseball.model;

import java.util.List;

public class Numbers {
    List<Integer> numbers;

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getValueAt(int index) {
        return numbers.get(index);
    }

    public int getIndexOf(int number) {
        return numbers.indexOf(number);
    }

    public boolean hasValue(int number) {
        return numbers.contains(number);
    }

    public boolean isValueAtIndexEquals(int index, int number) {
        return hasValue(number) && getValueAt(index) == number;
    }

}
