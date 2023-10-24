package baseball.slot;

import static baseball.GameClient.BALL_LENGTH;
import static baseball.GameClient.RANGE_MAXIMUM_VALUE;
import static baseball.GameClient.RANGE_MINIMUM_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RandomBaseballNumbersSlot extends BaseballNumbersSlot {
    @Override
    public void updateNumbers() {
        List<Integer> answerNumbers = new ArrayList<>();
        HashSet<Integer> chosenNumbers = new HashSet<>();
        while (chosenNumbers.size() < BALL_LENGTH) {
            int pickedNumber = Randoms.pickNumberInRange(RANGE_MINIMUM_VALUE, RANGE_MAXIMUM_VALUE);
            if (!chosenNumbers.contains(pickedNumber)) {
                chosenNumbers.add(pickedNumber);
                answerNumbers.add(pickedNumber);
            }
        }
        this.numbers = answerNumbers;
    }
}
