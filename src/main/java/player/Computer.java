package player;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Player {

    private List<Integer> baseballNumbers;
    private static final int NUMBER_LENGTH = 3;
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 9;


    @Override
    public void inputBaseballNumbers() {
        List<Integer> inputNumbers = new ArrayList<>();
        while (inputNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            if (!inputNumbers.contains(randomNumber)) {
                inputNumbers.add(randomNumber);
            }
        }
        this.baseballNumbers = inputNumbers;
    }

    @Override
    public List<Integer> getBaseballNumbers() {
        return this.baseballNumbers;
    }

}