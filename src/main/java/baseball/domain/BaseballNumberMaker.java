package baseball.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import baseball.domain.gamedata.BaseballNumber;
import java.util.Collections;

public class BaseballNumberMaker {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    public static final int COUNT = 3;

    public BaseballNumber make() {
        return new BaseballNumber(
                Collections.unmodifiableList(
                        pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT)
                )
        );
    }


}
