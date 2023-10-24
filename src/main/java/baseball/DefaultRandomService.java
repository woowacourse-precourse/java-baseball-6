package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomService implements RandomService {
    @Override
    public int pickNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
