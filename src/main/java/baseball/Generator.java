package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    public static final int LIST_LEN = 3;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;

    public static List<Integer> createAnswer() {
        List<Integer> answerList = new ArrayList<>();

        while (answerList.size() < LIST_LEN) {
            int num = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);

            if (answerList.contains(num)) {
                continue;
            }

            answerList.add(num);
        }

        return answerList;
    }
}
