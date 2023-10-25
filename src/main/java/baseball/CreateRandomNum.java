package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class CreateRandomNum {

    public List<Integer> create() {

        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            // 서로 다른 세자리 수
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }
}
