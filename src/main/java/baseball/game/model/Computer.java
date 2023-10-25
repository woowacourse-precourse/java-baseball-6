package baseball.game.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> numArr;

    private Computer() {
        List<Integer> numArr = new ArrayList<>();
        while (numArr.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numArr.contains(randomNumber)) {
                numArr.add(randomNumber);
            }
        }
        this.numArr = numArr;
    }

    public static Computer of() {
        return new Computer();
    }

    public Result compareToUser(User user) {
        Result result = new Result(0, 0);
        for (int i = 0; i < 3; i++) {
            if (numArr.get(i) == user.getDigitNum(i)) {
                result.setStrike(result.getStrike() + 1);
            } else if (numArr.contains(user.getDigitNum(i))) {
                result.setBall(result.getBall() + 1);
            }
        }
        return result;
    }
}
