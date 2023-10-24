package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    List<Number> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>();
    }

    public void addNumber(Number number) {
        this.numbers.add(number);
    }

    public boolean validateSize() {
        return this.numbers.size() == 3;
    }

    public void checkDuplicate(Number number) {
        if (this.numbers.contains(number)) {
            throw new IllegalArgumentException("Duplicate number " + number);
        }
    }

    public int getFirstDigit() {
        return 0;
    }

    public int getSecondDigit() {
        return 0;
    }

    public int getThirdDigit() {
        return 0;
    }
}
