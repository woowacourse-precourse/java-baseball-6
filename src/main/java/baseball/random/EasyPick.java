package baseball.random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class EasyPick implements RandomUtil{
    private static final RandomUtil instance = new EasyPick();

    private EasyPick(){

    }

    public static RandomUtil getInstance(){
        return instance;
    }

    @Override
    public List<Integer> getBallNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
