package baseball.model;

import baseball.constant.GameConstant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Answer {

    public static List<Integer> generate() {
        Set<Integer> randomSet = new HashSet<>();

        while (randomSet.size() < GameConstant.GAME_NUMBER_LENGTH) {
            randomSet.add(Randoms.pickNumberInRange(1, 9));
        }

        return new ArrayList<>(randomSet);
    }
}