package baseball;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Randoms;
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
            int randomNumber = generateRandomNumber();
            addNumber(randomNumbers, randomNumber);
        }
        return new Computer(randomNumbers);
    }

    public List<Integer> getComputer() {
        return computerNumbers;
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
    }

    private static void addNumber(List<Integer> numbers, int number) {
        if (!isDuplicatedNumber(numbers, number)) {
            numbers.add(number);
        }
    }

    private static boolean isDuplicatedNumber(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }
}
