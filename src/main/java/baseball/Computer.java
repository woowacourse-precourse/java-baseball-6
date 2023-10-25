package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static Computer computer;
    private List<Integer> randomNumber;

    private Computer() {
    }

    public static Computer getInstance() {
        if (computer == null) {
            computer = new Computer();
        }
        return computer;
    }

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber() {
        randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.randomNumber.contains(randomNumber)) {
                this.randomNumber.add(randomNumber);
            }
        }
    }
}
