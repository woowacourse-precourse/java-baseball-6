package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNum {
    private static final int COM_NUM_SIZE = 3;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 9;
    private List<Integer> number;

    public ComputerNum() {
        this.number = new ArrayList<>();
        setComNumber();
    }

    private void setComNumber() {
        while (number.size() < COM_NUM_SIZE) {
            int randomNum = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
            if (!isDuplicate(randomNum)) {
                number.add(randomNum);
            }
        }
    }

    private boolean isDuplicate(int randomNum) {
        return number.contains(randomNum);
    }

    public List<Integer> getNum() {
        return number;
    }
}
