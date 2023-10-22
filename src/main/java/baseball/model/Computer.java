package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private final int settingNumberLength;

    private List<Integer> numbers;

    public Computer(int numberLength) {
        this.settingNumberLength = numberLength;
    }

    public List<Integer> getNumbers() {
        if(numbers.isEmpty()) {
            return null;
        }

        return numbers;
    }

    public void setRandomNumbers() {
        Set<Integer> computerNumber = new HashSet<>();

        while(computerNumber.size() < settingNumberLength) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            computerNumber.add(randomNumber);
        }

        this.numbers = computerNumber.stream().toList();
    }
}
