package baseball.Controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RandomNumbersGenerator {
    private static final int COMPUTERNUMBERS_LENGTH = 3;
    private static final int NUMBER_RANGE_START = 1;
    private static final int NUMBER_RANGE_END = 9;

    public ArrayList<Integer> generateNumbers() {
        ArrayList<Integer> computernumbers = new ArrayList<>();
        while (computernumbers.size() < COMPUTERNUMBERS_LENGTH) {
            int randomnumber = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
                if (!computernumbers.contains(randomnumber))
                     computernumbers.add(randomnumber);
                }
        return computernumbers;
    }

}
