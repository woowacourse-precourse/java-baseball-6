package baseball.game.service;

import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerGenerator {

    public static String generateBaseballNumbers() {
        Map<Integer, Boolean> checkPoints = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int random = Randoms.pickNumberInRange(1, 9);
            if (checkPoints.containsKey(random)) {
                continue;
            }
            checkPoints.put(random, true);
            stringBuilder.append(random);
        } while (stringBuilder.length() < 3);
        return stringBuilder.toString();
    }
}
