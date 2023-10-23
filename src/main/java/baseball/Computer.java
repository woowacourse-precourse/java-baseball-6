package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int COMPUTER_NUMBERS_SIZE = 3;
    private static final int RANDOM_NUMBER_MIN = 1;
    private static final int RANDOM_NUMBER_MAX = 9;

    private final Numbers numbers;

    public Computer() {
        this.numbers = new Numbers(createComputerNumbers());
    }

    private List<Integer> createComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < COMPUTER_NUMBERS_SIZE) {
            addRandomNumber(computerNumbers);
        }
        return computerNumbers;
    }

    private void addRandomNumber(List<Integer> computerNumbers) {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        if (!computerNumbers.contains(randomNumber)) {
            computerNumbers.add(randomNumber);
        }
    }

    public NumbersScoreDto calculateScoreWithUserNumbers(Numbers user) {
        return this.numbers.calculateScore(user);
    }
}
