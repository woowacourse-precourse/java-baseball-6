package baseball.util;

import baseball.config.GameConfig;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int BASEBALL_LENGTH = GameConfig.BASEBALL_LENGTH;
    private static final int BASEBALL_START_NUMBER = GameConfig.BASEBALL_START_NUMBER;
    private static final int BASEBALL_END_NUMBER = GameConfig.BASEBALL_END_NUMBER;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BASEBALL_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_START_NUMBER, BASEBALL_END_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
