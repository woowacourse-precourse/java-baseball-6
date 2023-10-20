package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private int[] computerNums;

    public void pickRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.computerNums = computer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] getComputerNums() {
        return computerNums;
    }
}
