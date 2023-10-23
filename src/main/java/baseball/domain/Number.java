package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {

    List<Integer> gameNum = new ArrayList<>();

    public Number() {
        while (gameNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!gameNum.contains(randomNumber)) {
                gameNum.add(randomNumber);
            }
        }
    }

    public List<Integer> getGameNum() {
        return gameNum;
    }
}
