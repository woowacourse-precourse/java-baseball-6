package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 9;
    public static final int THREE_DIGIT = 3;

    private List<Integer> numbers;

    public Computer() {
        generateRandomThreeDigitNumber();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<Integer>(numbers);
    }

    private void generateRandomThreeDigitNumber() {
        numbers = new ArrayList<Integer>();
        while (numbers.size() < THREE_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
            addUniqueRandomNumber(randomNumber);
        }
    }

    private void addUniqueRandomNumber(int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

}
