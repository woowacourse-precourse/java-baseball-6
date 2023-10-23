package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameOperator {

    public List<Integer> createOpponent() {

        List<Integer> opponent = new ArrayList<>();

        while (opponent.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!opponent.contains(randomNumber)) {
                opponent.add(randomNumber);
            }
        }
        return opponent;
    }

    public boolean restart(List<Integer> player) {

        return player.get(0) == 1;
    }
}
