package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public List<Integer> createAnswer() {
        List<Integer> randNums = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            randNums.add(Randoms.pickNumberInRange(1, 9));
        }

        return randNums;
    }
}
