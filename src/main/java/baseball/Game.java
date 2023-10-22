package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> randomInt;

    public Game() {
        SetRandomInt();
    }

    public void SetRandomInt() {
        randomInt = new ArrayList<>();
        while (randomInt.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomInt.contains(randomNumber)) {
                randomInt.add(randomNumber);
            }
        }
    }
}
