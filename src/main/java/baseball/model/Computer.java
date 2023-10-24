package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> numbers;

    public Computer() {
        this.numbers = generateNumber();
    }

    private List<Integer> generateNumber() {
        List<Integer> generatedNumbers = new ArrayList<>();
        while (generatedNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumbers.contains(randomNumber)) generatedNumbers.add(randomNumber);
        }
        return generatedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}