package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> generate() {
        List<Integer> answerArray = new ArrayList<>();

        while (answerArray.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!answerArray.contains(randomNumber)) {
                answerArray.add(randomNumber);
            }
        }

        return answerArray;
    }
}
