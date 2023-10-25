package baseball.domain;

import baseball.domain.gamedata.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumberMaker {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    public static final int COUNT = 3;

    public BaseballNumber make() {

        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new BaseballNumber(Collections.unmodifiableList(numbers));
    }


}
