package player;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> computerBaseballNumber;
    private static final int MAX_LENGTH = 3;

    public Computer() {
        this.computerBaseballNumber = generateComputerRandomNumber();
    }

    private List<Integer> generateComputerRandomNumber() {
        List<Integer> computerBaseballNumber = new ArrayList<>();
        while (computerBaseballNumber.size() < MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBaseballNumber.contains(randomNumber)) {
                computerBaseballNumber.add(randomNumber);
            }
        }
        return computerBaseballNumber;
    }

    public List<Integer> getComputerBaseballNumber() {
        return computerBaseballNumber;
    }
}
