package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RandomNum {
    private ArrayList<Integer> num = new ArrayList<>();

    public RandomNum() {
        while (num.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!num.contains(randomNumber)) {
                num.add(randomNumber);
            }
        }
    }

    public ArrayList<Integer> getNum() {
        return num;
    }
}
