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
        while (randomNumbers.size() < Constants.NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
            addNumber(randomNumbers, randomNumber);
        }
        return randomNumbers;
    }

    private void addNumber(List<Integer> numbers, int number) {
        if (!isRedundantNumber(numbers, number)) {
            numbers.add(number);
        }
    }

    private boolean isRedundantNumber(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }
}
