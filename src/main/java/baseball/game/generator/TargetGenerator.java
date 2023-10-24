package baseball.game.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class TargetGenerator {

    private static final int LENGTH = 3;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 9;

    public List<Integer> generateTargetNumbers() {
        final List<Integer> targetNumbers = new ArrayList<>();

        while (targetNumbers.size() < LENGTH) {
            final int randomNumber = Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);

            if (!targetNumbers.contains(randomNumber)) {
                targetNumbers.add(randomNumber);
            }
        }

        return targetNumbers;
    }
}
