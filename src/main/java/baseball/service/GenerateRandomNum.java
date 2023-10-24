package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerateRandomNum {

    private final static int startInclusive = 1;
    private final static int endInclusive = 9;

    List<Integer> num = new ArrayList<>();

    public List<Integer> generateNum() {
        num.clear();
        while (num.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (!num.contains(randomNumber)) {
                num.add(randomNumber);
            }
        }
        return num;
    }
}

