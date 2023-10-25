package baseball.service.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(BaseballConstants.BASEBALL_START_NUMBER,
                BaseballConstants.BASEBALL_END_NUMBER);
    }
}
