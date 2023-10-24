package player;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer implements BaseballPlayer {

    private static final int MINT_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int BASEBALL_LENGTH = 3;
    private BaseballNumbers baseballNumbers;

    @Override
    public void inputBaseballNumbers() {
        List<BaseballNumber> computerBaseballNumber = new ArrayList<>();

        while (computerBaseballNumber.size() < BASEBALL_LENGTH) {
            addUniqueNumber(computerBaseballNumber);
        }

        this.baseballNumbers = new BaseballNumbers(computerBaseballNumber);
    }

    @Override
    public List<BaseballNumber> getPlayerBaseballNumbers() {
        return baseballNumbers.getBaseballNumbers();
    }

    private void addUniqueNumber(List<BaseballNumber> baseballNumbers) {
        int baseballNumber = Randoms.pickNumberInRange(MINT_NUMBER,
                MAX_NUMBER);
        if (!baseballNumbers.contains(new BaseballNumber(baseballNumber))) {
            baseballNumbers.add(new BaseballNumber(baseballNumber));
        }
    }
}
