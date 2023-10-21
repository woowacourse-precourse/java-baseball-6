package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNum {

    public static List<Integer> createRandomNum() {
        List<Integer> existRandomNum = new ArrayList<>();

        while (existRandomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!existRandomNum.contains(randomNumber)) {
                existRandomNum.add(randomNumber);
            }
        }

        return existRandomNum;
    }
}
