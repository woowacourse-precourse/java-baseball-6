package baseball.service;

import baseball.common.Size;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallGenerator {
    public List<Integer> createBall() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < Size.NUMBER.getValue()) {
            int add = Randoms.pickNumberInRange(Size.MIN.getValue(), Size.MAX.getValue());
            if (!result.contains(add)) {
                result.add(add);
            }
        }
        return result;
    }
}
