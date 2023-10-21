package baseball.utils;

import static baseball.utils.BaseballNumberConstants.END_RANGE;
import static baseball.utils.BaseballNumberConstants.MAX_BASEBALL_NUMBER_SIZE;
import static baseball.utils.BaseballNumberConstants.START_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumberGenerator {

    private BaseballNumberGenerator() {
        throw new UnsupportedOperationException();
    }
    public static List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_BASEBALL_NUMBER_SIZE.getConstant()) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE.getConstant(), END_RANGE.getConstant());
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return Collections.unmodifiableList(computer);
    }
}
