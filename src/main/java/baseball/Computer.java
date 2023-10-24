package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    Validator validator = new Validator();

    public Computer() {
    }

    private List<String> baseballNum = new ArrayList<>();

    public String createValidBaseballNum() {
        while (baseballNum.size() < 3) {
            String invalidNum = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (validator.validNumNotInList(invalidNum, baseballNum)) {
                continue;
            }
            baseballNum.add(invalidNum);
        }
        return String.join("", baseballNum);
    }
}
