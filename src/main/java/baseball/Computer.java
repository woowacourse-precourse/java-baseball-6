package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int MINRANGE = 1;
    private static final int MAXRANGE = 9;
    private static final int SIZE = 3;

    public List<Integer> createComputerNum() {
        BaseballNumber baseballNumber = null;
        try {
            baseballNumber = new BaseballNumber(createBaseBallComputerNum());
        } catch (IllegalArgumentException e) {
            createBaseBallComputerNum();
        }
        return baseballNumber.getBaseballNum();
    }

    public List<Integer> createBaseBallComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MINRANGE, MAXRANGE);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }
}
