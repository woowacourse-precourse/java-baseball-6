package baseball.start;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputeNumbers {

    private List<Integer> computerNumbers;

    public ComputeNumbers() {
        computerNumbers = new ArrayList<>();
    }

    public List<Integer> getComputerNumbers() {
        return this.computerNumbers;
    }

    public void pickAnswerNumbers() {
        if (computerNumbers.size() > 0) {
            computerNumbers = new ArrayList<>();
        }
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }
}
