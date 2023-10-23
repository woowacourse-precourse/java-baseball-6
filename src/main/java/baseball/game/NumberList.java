package baseball.game;

import java.util.ArrayList;

public class NumberList {
    ArrayList<Number> numbers;
    static int MAX_NUM_LEN = 3;

    public NumberList(String inputString) {
        this.numbers = new ArrayList<>();
        for (char c : inputString.toCharArray()) {
            Number number = new Number(c);
            this.add(number);
        }
        this.ValidateCountLimit();
    }

    public NumberList() {
        this.numbers = new ArrayList<>();
    }

    public void add(Number number) {
        this.ValidateUpperCountLimit();
        this.ValidateDuplicate(number);
        numbers.add(number);
    }

    public void ValidateDuplicate(Number number) {
        for (int i = 0; i < this.numbers.size() - 1; i++) {
            if (number.equals(numbers.get(i))) {
                throw new IllegalArgumentException("Numbers are duplicated.");
            }
        }
    }

    public void ValidateCount() {
        if (numbers.size() >= MAX_NUM_LEN) {
            throw new IllegalArgumentException("Input that exceeds MAX_NUM_LEN.");
    public void ValidateCountLimit() {
        if (numbers.size() != MAX_NUM_LEN) {
            throw new IllegalArgumentException("The number entered is not BASEBALL_NUM_COUNT.");
        }
    }

    public void ValidateUpperCountLimit() {
            throw new IllegalArgumentException("Input that exceeds BASEBALL_NUM_COUNT.");
        }
    }
}