package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {

    private List<Integer> randomValue = new ArrayList<>(3);

    public void makeRandom() {
        randomValue.clear();
        while (randomValue.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomValue.contains(randomNumber)) {
                randomValue.add(randomNumber);
            }
        }
    }

}
