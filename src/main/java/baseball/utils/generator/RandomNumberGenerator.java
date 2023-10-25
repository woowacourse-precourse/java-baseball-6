package baseball.utils.generator;

import baseball.number.Number;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;

    @Override
    public Number generate() {
        return new Number(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
    }
}
