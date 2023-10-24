package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    static final int NUMBER_OF_BALLS = 3;
    static final int MINIMUM_RANDOM_NUMBER = 1;
    static final int MAXIMUM_RANDOM_NUMBER = 9;
    private List<Integer> randomIntegerList;

    public Computer() {
        randomIntegerList = makeRandomNum();
    }

    private List<Integer> makeRandomNum() {
        randomIntegerList = new ArrayList<>();
        while (randomIntegerList.size() < NUMBER_OF_BALLS) {
            int randomNum = Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
            if (!randomIntegerList.contains(randomNum)) {
                randomIntegerList.add(randomNum);
            }
        }
        return randomIntegerList;
    }

    public List<Integer> getRandomIntegerList() {
        return randomIntegerList;
    }
}
