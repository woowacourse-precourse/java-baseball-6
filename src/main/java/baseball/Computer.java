package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {

    private static final Integer NUMBER_DIGIT = 3;
    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 9;

    private Set answer = new LinkedHashSet();

    public Computer() {
        while (answer.size() < NUMBER_DIGIT) {
            answer.add(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }
    }
}
