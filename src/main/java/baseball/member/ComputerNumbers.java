package baseball.member;

import baseball.controller.BaseballGameController;
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

    public Integer getComputerNumberAtIndex(int index) {
        return getComputerNumbers().get(index);
    }

    private List<Integer> createComputerNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (!isValidDigit(randomNumbers)) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (isNumberNotDuplicate(randomNumbers, randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    private boolean isNumberNotDuplicate(List<Integer> numbers, int number) {
        return !numbers.contains(number);
    }

    private boolean isValidDigit(List<Integer> numbers) {
        return numbers.size() == BaseballGameController.GAME_NUMBER_DIGIT;
    }
}
