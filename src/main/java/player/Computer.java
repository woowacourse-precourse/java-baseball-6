package player;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computerBaseballNumber;
    private static final int MAX_LENGTH = 3;

    public Computer() {

    }

    public void generateComputerRandomNumber() {
        List<Integer> computerBaseballNumber = new ArrayList<>();
        while (computerBaseballNumber.size() < MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBaseballNumber.contains(randomNumber)) {
                computerBaseballNumber.add(randomNumber);
            }
        }
        this.computerBaseballNumber = computerBaseballNumber;
    }

    public List<Integer> getComputerBaseballNumber() {
        return computerBaseballNumber;
    }
}
