package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

import static baseball.model.UserAnswer.*;

public class GameAnswerManager {

    private final Map<Integer, Integer> answerMap;  // key: number, value: order

    public GameAnswerManager() {
        this.answerMap = new HashMap<>();
    }

    public void setAnswer() {
        while (answerMap.size() < ANSWER_DIGITS) {
            int randNum = Randoms.pickNumberInRange(MIN_NUM_RANGE, MAX_NUM_RANGE);
            answerMap.put(randNum, answerMap.size());
        }
    }
}
