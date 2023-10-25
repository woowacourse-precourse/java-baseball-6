package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumber;
    private boolean used[] = new boolean[10];

    public void generateComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
                used[randomNumber] = true;
            }
        }
        this.computerNumber = computerNumber;
    }

    public boolean[] getUsedArray() {
        return used;
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
