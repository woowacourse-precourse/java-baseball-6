package baseball;

import baseball.constants.Constants;
import baseball.utils.Util;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> computerNumbers;

    private Computer(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public static Computer create() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < Constants.NUMBERS_SIZE) {
            int randomNumber = Util.generateRandomNumber();
            Util.addNumber(randomNumbers, randomNumber);
        }
        return new Computer(randomNumbers);
    }

    public List<Integer> getComputer() {
        return computerNumbers;
    }
}
