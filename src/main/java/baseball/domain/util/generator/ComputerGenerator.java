package baseball.domain.util.generator;

import baseball.domain.config.GameConfig;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerGenerator {
    private static final int BASEBALL_SIZE = GameConfig.BASEBALL_SIZE;
    private static final int BASEBALL_MIN_NUMBER = GameConfig.BASEBALL_MIN_NUMBER;
    private static final int BASEBALL_MAX_NUMBER = GameConfig.BASEBALL_MAX_NUMBER;

    public List<Integer> getTarget() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < BASEBALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_MIN_NUMBER, BASEBALL_MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
