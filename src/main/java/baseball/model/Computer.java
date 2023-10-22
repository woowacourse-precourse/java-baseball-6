package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computerNumber;

    private Computer(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public static Computer generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new Computer(computer);
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
