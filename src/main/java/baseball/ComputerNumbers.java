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
        while(randomNumbers.size() < BaseballGame.GAME_NUMBER_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
