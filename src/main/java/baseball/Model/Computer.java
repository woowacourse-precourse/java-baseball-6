package baseball.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 9;
    public static final int THREE_DIGIT = 3;
    private List<Integer> numbers;

    public Computer() {
        generateRandomThreeDigitNumber();
    }

    private void generateRandomThreeDigitNumber() {
        List<Integer> allNumbers = new ArrayList<Integer>();

        for (int i = MIN_NUMBER_RANGE; i <= MAX_NUMBER_RANGE; i++) {
            allNumbers.add(i);
        }

        Collections.shuffle(allNumbers);
        this.numbers = new ArrayList<Integer>(allNumbers.subList(0, THREE_DIGIT));
    }

    public List<Integer> getNumbers() {
        return new ArrayList<Integer> (numbers);
    }
}
