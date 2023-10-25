package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> computerNumbers;

    private void setComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        this.computerNumbers = computerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        this.setComputerNumbers();
        return this.computerNumbers;
    }
}
