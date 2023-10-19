package baseball.Randomgenerator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Ranomgenerator implements Randomgenerator{
    @Override
    public List<Integer> getRandom() {
        List<Integer> randomValue = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return randomValue;
    }
}
