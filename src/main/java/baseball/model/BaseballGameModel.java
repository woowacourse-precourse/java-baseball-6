package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballGameModel {

    private final List<Integer> computerNumbers = new ArrayList<>();

    void generateRandomNumbers(){
        while (computerNumbers.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    List<Integer> getComputerNumbers(){
        return computerNumbers;
    }

    void clearComputerNumbers() {
        computerNumbers.clear();
    }
}
