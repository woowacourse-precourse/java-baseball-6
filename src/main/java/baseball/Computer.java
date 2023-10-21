package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computer;

    public Computer() {
        this.computer = generateComputerNumber();
    }

    public List<Integer> getComputer() {
        return computer;
    }

    private List<Integer> generateComputerNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNumber(randomNumbers, randomNumber);
        }
        return randomNumbers;
    }

    private void addNumber(List<Integer> numbers, int number) {
        if (!validateRedundantNumber(numbers, number)) {
            numbers.add(number);
        }
    }

    private boolean validateRedundantNumber(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }
}
