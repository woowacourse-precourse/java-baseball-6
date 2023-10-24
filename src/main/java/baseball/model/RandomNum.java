package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNum {

    private static final int RANDOM_NUM_START = 1;
    private static final int RANDOM_NUM_END = 9;
    private static final int RANDOM_NUM_LENGTH = 3;

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNum = new ArrayList<>();
        while (randomNum.size() < RANDOM_NUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUM_START, RANDOM_NUM_END);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
        return randomNum;
    }
}