package baseball.domain;

import java.util.List;

public class Player {

    private List<Integer> numbers;

    public Player() {
    }

    public Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setNumbers(List<Integer> newNumbers) {
        PlayerValidator.validate(newNumbers);
        numbers = newNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }
}