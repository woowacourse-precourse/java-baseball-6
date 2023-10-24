package player;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer implements BaseballPlayer {

    private static final int MAX_LENGTH = 3;
    private BaseballNumbers baseballNumbers;

    @Override
    public void inputBaseballNumbers() {
        List<Integer> computerBaseballNumber = new ArrayList<>();

        while (computerBaseballNumber.size() < MAX_LENGTH) {
            Integer baseballNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBaseballNumber.contains(baseballNumber)) {
                computerBaseballNumber.add(baseballNumber);
            }
        }

        this.baseballNumbers = new BaseballNumbers(computerBaseballNumber);
    }

    @Override
    public List<Integer> getBaseballNumbers() {
        return baseballNumbers.getBaseballNumbers();
    }
}
