package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerater {
    private static final int ANSWER_LENGTH = 3;

    public static List<Integer> RandomNumberGenerater() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
