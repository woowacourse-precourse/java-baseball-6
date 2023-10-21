package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> randomNums = new ArrayList<>();

    public void genNumbers() {
        randomNums = new ArrayList<>();

        while (randomNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNums.contains(randomNumber)) {
                randomNums.add(randomNumber);
            }
        }
    }

}
