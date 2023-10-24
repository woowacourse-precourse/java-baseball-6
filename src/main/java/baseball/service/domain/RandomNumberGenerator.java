package baseball.service.domain;

import static baseball.service.domain.BaseballConstants.BASEBALL_END_NUMBER;
import static baseball.service.domain.BaseballConstants.BASEBALL_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(BASEBALL_START_NUMBER, BASEBALL_END_NUMBER);
    }
}
