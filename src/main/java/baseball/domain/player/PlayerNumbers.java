package baseball.domain.player;

import baseball.global.converter.NumbersConverter;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumbers {
    private List<Integer> numbers;

    public PlayerNumbers() {
        this.numbers = new ArrayList<>();
    }

    public void inputNumbers(String numbers) {
        if(this.numbers.size() == 0) {
            List<Integer> inputNumbers = NumbersConverter.convertNumbers(numbers);
            this.numbers.addAll(inputNumbers);
        }
    }

    public void clearPlayerNumbers() {
        if(numbers.size() > 0) {
            numbers.clear();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
