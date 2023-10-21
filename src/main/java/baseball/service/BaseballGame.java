package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.VisibleForTesting;

public class BaseballGame {

    private final List<Integer> baseballGameNumbers = new ArrayList<>();

    public BaseballGame() {
        initBaseballGameNumbers();
    }

    private void initBaseballGameNumbers() {
        while (baseballGameNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballGameNumbers.contains(randomNumber)) {
                baseballGameNumbers.add(randomNumber);
            }
        }
    }

    @VisibleForTesting
    protected int getBaseballGameNumbersSize() {
        // Only for testing
        return baseballGameNumbers.size();
    }

    public boolean isPlayerWin(List<Integer> playerTargetNums) {
        return true;
    }
}
