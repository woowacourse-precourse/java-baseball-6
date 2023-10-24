package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.BASEBALL_NUM_LIMIT_LENGTH;

public class Computer {
    Validator validator = new Validator();

    public Computer() {
    }


    public String createValidBaseballNum() {
        List<String> baseballNum = new ArrayList<>();
        while (baseballNum.size() < BASEBALL_NUM_LIMIT_LENGTH) {
            String invalidNum = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (validator.validNumNotInList(invalidNum, baseballNum)) {
                continue;
            }
            baseballNum.add(invalidNum);
        }
        return String.join("", baseballNum);
    }
}
