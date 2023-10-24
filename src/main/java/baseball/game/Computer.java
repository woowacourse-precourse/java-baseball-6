package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public Computer() {
    }

    public List<Integer> createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }
        return computerNumber;
    }

    public void compareEachNumber() {
    }

    public void createResultMessage() {
    }

    public void checkResult() {
    }

    public void decideGameEndAndRestart() {
    }


}
