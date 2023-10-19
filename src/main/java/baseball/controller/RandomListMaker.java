package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomListMaker {
    private final static int MINIMUM_NUM_IN_RANGE = 1;
    private final static int MAXIMUM_NUM_IN_RANGE = 9;
    private final static int LIST_SIZE = 3;

    public static List<Integer> generateRandomNumbers(){
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() != LIST_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUM_IN_RANGE, MAXIMUM_NUM_IN_RANGE);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
