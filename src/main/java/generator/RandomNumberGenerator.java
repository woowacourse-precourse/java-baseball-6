package generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements RandomGenerator<List<Integer>> {
    private static final int RANGE_MAX = 9;
    private static final int RANGE_MIN = 1;

    @Override
    public List<Integer> generate(Integer size) {
        List<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

}
