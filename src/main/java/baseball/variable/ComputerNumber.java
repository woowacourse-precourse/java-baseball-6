package baseball.variable;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class ComputerNumber {
    public List<Integer> computerNumber = new ArrayList<>();

    public void setComputerNumber() {
        while (computerNumber.size() < 3) {
            getRandomNumber();
        }
    }

    private void getRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    public void clearComputerNumber() {
        computerNumber.clear();
    }
}
