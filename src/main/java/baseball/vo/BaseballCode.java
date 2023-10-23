package baseball.vo;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class BaseballCode {
    private final List<Integer> codes;

    public BaseballCode(List<Integer> codes) {
        this.codes = codes;
    }

    public BaseballCode makeNewBaseballCode() {
        List<Integer> codes = new ArrayList<>();
        generateRandomCode(codes);

        return new BaseballCode(codes);
    }

    private static void generateRandomCode(List<Integer> codes) {
        while (codes.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!codes.contains(randomNumber)) {
                codes.add(randomNumber);
            }
        }
    }

    public Integer getBaseballCodeSize() {
        return codes.size();
    }

    public Integer getBaseballCodeElement(int index) {
        return codes.get(index);
    }
}
