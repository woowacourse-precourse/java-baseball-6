package baseball.game;

import static baseball.game.Constant.BASEBALL_NUM_COUNT;

import java.util.ArrayList;

public class NumberList {
    ArrayList<Number> numbers;

    public NumberList(String inputString) {
        this.numbers = new ArrayList<>();
        for (char c : inputString.toCharArray()) {
            Number number = new Number(c);
            this.add(number);
        }
        this.validateCountLimit();
    }

    public NumberList() {
        this.numbers = new ArrayList<>();
    }

    public void add(Number number) {
        this.validateUpperCountLimit();
        this.validateDuplicate(number);
        numbers.add(number);
    }

    public void validateDuplicate(Number number) {
        for (int i = 0; i < this.numbers.size(); i++) {
            if (number.equals(numbers.get(i))) {
                throw new IllegalArgumentException("Numbers are duplicated.");
            }
        }
    }

    public void validateCountLimit() {
        if (numbers.size() != BASEBALL_NUM_COUNT) {
            throw new IllegalArgumentException("The number entered is not BASEBALL_NUM_COUNT.");
        }
    }

    public void validateUpperCountLimit() {
        if (numbers.size() >= BASEBALL_NUM_COUNT) {
            throw new IllegalArgumentException("Input that exceeds BASEBALL_NUM_COUNT.");
        }
    }
}