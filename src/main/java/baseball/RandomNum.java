package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNum {

    private List<Integer> existRandomNum = new ArrayList<>();

    public RandomNum() {
        while (existRandomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!existRandomNum.contains(randomNumber)) {
                existRandomNum.add(randomNumber);
            }
        }
    }

    public List<Integer> getExistRandomNum() {
        return existRandomNum;
    }
}
