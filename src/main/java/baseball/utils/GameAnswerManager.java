package baseball.utils;

import baseball.model.dto.AnswerComparisonResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.model.UserAnswer.*;

public class GameAnswerManager {

    private final Map<Integer, Integer> answerMap = new HashMap<>();  // key: number, value: order

    public void setAnswer() {
        answerMap.clear();
        while (answerMap.size() < ANSWER_DIGITS) {
            int randNum = Randoms.pickNumberInRange(MIN_NUM_RANGE, MAX_NUM_RANGE);
            answerMap.put(randNum, answerMap.size());
        }
    }

    public AnswerComparisonResult compareAnswer(List<Integer> answerNumbers) {
        int numOfBalls = 0;
        int numOfStrikes = 0;

        for (int i = 0; i < ANSWER_DIGITS; i++) {
            Integer answerNum = answerNumbers.get(i);
            if (!answerMap.containsKey(answerNum)) {
                continue;
            }

            Integer order = answerMap.get(answerNum);
            if (i == order) {
                numOfStrikes++;
            } else {
                numOfBalls++;
            }
        }

        return new AnswerComparisonResult(numOfBalls, numOfStrikes);
    }
}
