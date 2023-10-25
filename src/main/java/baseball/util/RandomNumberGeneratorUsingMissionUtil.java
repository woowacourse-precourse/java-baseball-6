package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorUsingMissionUtil implements IRandomValueGenerator<Integer> {

    @Override
    public Integer generate() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
