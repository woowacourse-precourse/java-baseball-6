package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    public static List<Integer> createAnswer() {
        List<Integer> answerList = new ArrayList<>();

        while (answerList.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 10);

            if (answerList.contains(num)) {
                continue;
            }

            answerList.add(num);
        }

        return answerList;
    }
}
