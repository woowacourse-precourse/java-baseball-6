package baseball.util;

import static baseball.util.Constant.BASEBALL_GAME_NUMBER_DIGIT;
import static baseball.util.Constant.END_INCLUSIVE;
import static baseball.util.Constant.START_INCLUSIVE;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BASEBALL_GAME_NUMBER_DIGIT.getValue()) {
            int pickNumberInRange = pickNumberInRange(START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue());
            if (!numbers.contains(pickNumberInRange)) {
                numbers.add(pickNumberInRange);
            }
        }
        return numbers;
    }
}
