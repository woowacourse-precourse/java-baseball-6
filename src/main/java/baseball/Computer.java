package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> computerNumbers;

    private Computer(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public List<Integer> getComputer() {
        return computerNumbers;
    }

    public static Computer create() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < Constant.NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER);
            addNumber(randomNumbers, randomNumber);
        }
        return new Computer(randomNumbers);
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
