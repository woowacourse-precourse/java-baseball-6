package baseball.domain;

import static baseball.constant.Constant.BASEBALL_GAME_NUMBER_DIGIT;
import static baseball.constant.Constant.END_INCLUSIVE;
import static baseball.constant.Constant.START_INCLUSIVE;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    public BaseBallGameNumberGenerator() {
        this.numbers = new ArrayList<>();
    }

    @Override
    public List<Integer> generateNumbers() {
        while (numbers.size() < BASEBALL_GAME_NUMBER_DIGIT) {
            int pickNumberInRange = pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            addIfNotDuplicate(pickNumberInRange);
        }
        return numbers;
    }

    private void addIfNotDuplicate(final int pickNumberInRange) {
        if (!numbers.contains(pickNumberInRange)) {
            numbers.add(pickNumberInRange);
        }
    }
}
