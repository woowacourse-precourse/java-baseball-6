package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private NumberGenerator() { }

    public static List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while(answer.size() < GameRules.INPUT_LIMIT.getValue()) {
            int answerNumber = Randoms.pickNumberInRange(GameRules.START.getValue(), GameRules.END.getValue());
            if(!answer.contains(answerNumber)) {
                answer.add(answerNumber);
            }
        }
        return answer;
    }
}
