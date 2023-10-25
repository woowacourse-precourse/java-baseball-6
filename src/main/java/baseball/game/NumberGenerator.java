package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberGenerator {

    public Map<Integer, Integer> randomNum() {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ball = getBall();
        for (int i = 0; i <=2; i++) {
            map.put(ball.get(i), i);
        }
        return map;

    }


    private List<Integer> getBall() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

}
