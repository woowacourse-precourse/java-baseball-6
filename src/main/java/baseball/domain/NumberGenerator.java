package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    // 정답 생성 후 answer객체에 저장
    public static List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < GameRules.INPUT_LIMIT.getBalls(); i++) {
            int answerNumber = Randoms.pickNumberInRange(GameRules.START.getBalls(), GameRules.END.getBalls());
            answer.add(answerNumber);
        }
        return answer;
    }
}
