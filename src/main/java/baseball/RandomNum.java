package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNum {
    private List<Integer> num = new ArrayList<>();

    public RandomNum() {
        while (num.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!num.contains(randomNumber)) {
                num.add(randomNumber);
                System.out.println(randomNumber);
            }
        }
    }

    public List<Integer> getNum() {
        return num;
    }
}
