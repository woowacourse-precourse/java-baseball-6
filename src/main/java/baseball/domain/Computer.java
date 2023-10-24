package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNums;

    public Computer() {
        initRandomNum();
    }

    public List<Integer> getComputerNums() {
        return randomNums;
    }

    private void initRandomNum() {
        randomNums = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            randomNums.add(getUniqueNumber());
        }
    }

    private int getUniqueNumber() {
        int randomNum;
        do {
            randomNum = Randoms.pickNumberInRange(1, 9);
        } while (randomNums.contains(randomNum));
        return randomNum;
    }
}
