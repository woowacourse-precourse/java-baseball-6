package baseball.game.service.answer;

import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerGenerator {

    public String generateBaseballNumbers(int digits) {
        Map<Integer, Boolean> checkPoints = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < digits) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (checkPoints.containsKey(random)) {
                continue;
            }
            checkPoints.put(random, true);
            stringBuilder.append(random);
        }
        return stringBuilder.toString();
    }
}
