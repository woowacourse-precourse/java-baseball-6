package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerNumbers {
    private final List<Integer> computerNumbers;

    public ComputerNumbers() {
        this.computerNumbers = createComputerNumbers();
    }

    public List<Integer> getComputerNumbers() {
        List<Integer> clonedComputerNumbers = new ArrayList<>(computerNumbers);
        return Collections.unmodifiableList(clonedComputerNumbers);
    }

    private List<Integer> createComputerNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        do {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (isNumbersNotDuplicate(randomNumbers, randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        } while(!isValidDigit(randomNumbers));
        return randomNumbers;
    }

    private boolean isNumbersNotDuplicate(List<Integer> numbers, int number) {
        return !numbers.contains(number);
    }

    private boolean isValidDigit(List<Integer> numbers) {
        return numbers.size() == BaseballGame.GAME_NUMBER_DIGIT;
    }
}
