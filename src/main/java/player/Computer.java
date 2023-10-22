package player;

import static constant.NumberConstant.MAX_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer extends BaseballPlayer {

    @Override
    public void inputBaseballNumbers() {
        List<BaseballNumber> computerBaseballNumber = new ArrayList<>();

        while (computerBaseballNumber.size() < MAX_LENGTH) {
            BaseballNumber baseballNumber = new BaseballNumber(Randoms.pickNumberInRange(1, 9));
            if (!computerBaseballNumber.contains(baseballNumber)) {
                computerBaseballNumber.add(baseballNumber);
            }
        }
        
        super.baseballNumbers = new BaseballNumbers(computerBaseballNumber);
    }
}
