package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballGameModel {

    private final List<Integer> computerNumbers = new ArrayList<>();

    public void generateRandomNumbers() {
        while (computerNumbers.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void clearComputerNumbers() {
        computerNumbers.clear();
    }
}
