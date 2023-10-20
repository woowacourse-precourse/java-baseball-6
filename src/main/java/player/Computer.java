package player;

import static constant.NumberConstant.MAX_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer extends BaseballPlayer {

    @Override
    public void inputBaseballNumber() {
        List<Integer> computerBaseballNumber = new ArrayList<>();
        while (computerBaseballNumber.size() < MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBaseballNumber.contains(randomNumber)) {
                computerBaseballNumber.add(randomNumber);
            }
        }
        super.baseballNumber = computerBaseballNumber;
    }
}
