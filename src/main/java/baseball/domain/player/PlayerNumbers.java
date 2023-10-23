package baseball.domain.player;

import baseball.global.converter.NumbersConverter;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumbers {
    private List<Integer> numbers;
    private final NumbersConverter numbersConverter;

    public PlayerNumbers(NumbersConverter numbersConverter) {
        this.numbersConverter = numbersConverter;
        this.numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void inputNumbers(String numbers) {
        if(this.numbers.size() == 0) {
            List<Integer> inputNumbers = numbersConverter.convertNumbers(numbers);
            this.numbers.addAll(inputNumbers);
        }
    }

    public void clearPlayerNumbers() {
        if(numbers.size() > 0) {
            numbers.clear();
        }
    }
}
