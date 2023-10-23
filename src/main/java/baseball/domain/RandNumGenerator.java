package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandNumGenerator {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;

    private RandNumGenerator() {
    }

    private List<Integer> makeRandNumbers() {
        List<Integer> randNumbers = new ArrayList<>();
        do {
            int randNum = makeRandNumInRange();
            if (!randNumbers.contains(randNum)) {
                randNumbers.add(randNum);
            }
        } while (randNumbers.size() < BaseBallNumber.LENGTH);
        return randNumbers;
    }

    public static int concatRandNumbersToInt(List<Integer> list) {
        return list.stream()
                .reduce((acc, cur) -> acc * 10 + cur)
                .get(); // TODO : make non-optional return
    }

    private static int makeRandNumInRange() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
