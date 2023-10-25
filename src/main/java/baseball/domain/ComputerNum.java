package baseball.domain;

import static baseball.resources.GameConst.*;

import baseball.resources.GameConst;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNum {
    private List<Integer> number;

    public ComputerNum() {
        this.number = new ArrayList<>();
        setComNumber();
    }

    public List<Integer> getNum() {
        return number;
    }

    private void setComNumber() {
        while (number.size() < NUM_SIZE) {
            int randomNum = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
            if (!isDuplicate(randomNum)) {
                number.add(randomNum);
            }
        }
    }

    private boolean isDuplicate(int randomNum) {
        return number.contains(randomNum);
    }
}
