package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator{

    @Override
    public int generateNumberInRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
    
}
