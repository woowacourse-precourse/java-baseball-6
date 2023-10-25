package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private Computer() {
    }

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < Constants.MAX_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
