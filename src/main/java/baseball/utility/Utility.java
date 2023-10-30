package baseball.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static List<Integer> getRandomList(int length) {
        List<Integer> randomList = new ArrayList<>();

        while (randomList.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }

        return randomList;
    }
}
