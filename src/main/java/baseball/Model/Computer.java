package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 9;
    public static final int THREE_DIGIT = 3;

    private Numbers numbers;

    public Computer() {
        numbers = new Numbers(generateComputerNumbers());
    }

    private List<Integer> generateComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<Integer>();
        generateRandomThreeDigit(computerNumbers);
        return computerNumbers;
    }

    private void generateRandomThreeDigit(List<Integer> computerNumbers) {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
            addUniqueNumber(computerNumbers, randomNumber);
        }
    }

    private static void addUniqueNumber(List<Integer> computerNumbers, int randomNumber) {
        if (!computerNumbers.contains(randomNumber)) {
            computerNumbers.add(randomNumber);
        }
    }

    public Numbers getNumbers() {
        return numbers;
    }

}
