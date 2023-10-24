package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> generateNumber() {
        List<Integer> computerNums = new ArrayList<>();

        while (computerNums.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computerNums.contains(randomNum)) {
                computerNums.add(randomNum);
            }
        }
        return computerNums;
    }
}
