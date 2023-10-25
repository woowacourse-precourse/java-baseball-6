package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final RandomNumberGenerator randomNumberGenerator;
    public List<Integer> computerNumbers;

    Computer(RandomNumberGenerator randomNumber) {
        this.computerNumbers = new ArrayList<>();
        this.randomNumberGenerator = randomNumber;
        this.generateNumber();
    }

    public List<Integer> getComputerNumbers() {
        return this.computerNumbers;
    }

    private void generateNumber() {
        while (computerNumbers.size() < GameConstant.PLAY_INPUT_LENGTH) {
            int number = randomNumberGenerator.pickNumber(1, 9);
            if (!computerNumbers.contains(number)) {
                computerNumbers.add(number);
            }
        }
    }

    public String guessNumber(List<Integer> inputNumber) {
        Count count = new Count();
        for (int i = 0; i < GameConstant.PLAY_INPUT_LENGTH; i++) {
            if (computerNumbers.get(i).equals(inputNumber.get(i))) {
                count.increaseStrike();
            } else if (computerNumbers.contains(inputNumber.get(i))) {
                count.increaseBall();
            }
        }
        return count.getResultString();
    }
}
