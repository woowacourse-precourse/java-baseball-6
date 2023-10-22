package baseball;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    public List<Integer> createRandomNumber() {
        List<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < 3) {
            int num = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,9);
            if (!computerNums.contains(num)) {
                computerNums.add(num);
            }
        }
        return computerNums;
    }
}
