package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    static final int NUMBER_OF_BALLS = 3;
    List<Integer> randomIntegerList;

    public Computer() {
        this.randomIntegerList = makeRandomNum();
    }
    private List<Integer> makeRandomNum() {
        randomIntegerList = new ArrayList<>();
        while (randomIntegerList.size() < NUMBER_OF_BALLS) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
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
