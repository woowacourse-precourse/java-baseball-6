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
    }

    public NumberList() {
        this.numbers = new ArrayList<>();
    }

    public void add(Number number) {
        this.ValidateCount();
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
        }
    }
}