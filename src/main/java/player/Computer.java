package player;

import static constant.BaseballConstant.MAX_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer extends BaseballPlayer {

    @Override
    public void inputBaseballNumbers() {
        List<Integer> computerBaseballNumber = new ArrayList<>();

        while (computerBaseballNumber.size() < MAX_LENGTH) {
            Integer baseballNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBaseballNumber.contains(baseballNumber)) {
                computerBaseballNumber.add(baseballNumber);
            }
        }

        super.baseballNumbers = new BaseballNumbers(computerBaseballNumber);
    }
}
