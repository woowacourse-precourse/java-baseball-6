package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumberGenerator {
    public static List<Integer> generateThreeDigits() {
        List<Integer> threeDigits = new ArrayList<>();
        while (threeDigits.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!threeDigits.contains(randomNumber)) {
                threeDigits.add(randomNumber);
            }
        }
        return threeDigits;
    }
}
