package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private RandomNumberGenerator randomNumberGenerator;
    private int numberLength;
    public List<Integer> computerNumbers;

    Computer(RandomNumberGenerator randomNumber, int numberLength) {
        this.numberLength = numberLength;
        this.computerNumbers = new ArrayList<>();
        this.randomNumberGenerator = randomNumber;
        this.generateNumber();
    }

    public List<Integer> getComputerNumbers() {
        return this.computerNumbers;
    }

    private void generateNumber() {
        while (computerNumbers.size() < numberLength) {
            int number = randomNumberGenerator.pickNumber(1, 9);
            if (!computerNumbers.contains(number)) {
                computerNumbers.add(number);
            }
        }
    }

    public String guessNumber(List<Integer> inputNumber) {
        Count count = new Count();
        for (int i = 0; i < inputNumber.size(); i++) {
            if (computerNumbers.get(i) == inputNumber.get(i)) {
                count.increaseStrike();
            } else if (computerNumbers.contains(inputNumber.get(i))) {
                count.increaseBall();
            }
        }
        return count.getResultString();
    }
}
