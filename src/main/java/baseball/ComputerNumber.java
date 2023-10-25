package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Application.MAX_NUMBER_SIZE;

public class ComputerNumber {
    private final int RANDOM_RANGE_START = 1;
    private final int RANDOM_RANGE_END = 9;
    private List<Integer> numbers;
    public ComputerNumber() {
        numbers = new ArrayList<>();
        addNumbers();
    }
    public void addNumbers() {
        while (numbers.size() < MAX_NUMBER_SIZE) {
            numbers.add(getRandomNumber());
        }
    }
    private int getRandomNumber() {
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END);
        } while (numbers.contains(randomNumber));
        return randomNumber;
    }
    public boolean isEqualNumberSameIndex(int number, int index) {
        return numbers.get(index) == number;
    }
    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }
}

