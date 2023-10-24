package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {
    /*
     * 정답 생성
     * 중복되지 않은 세개의 숫자
     * 1 ~ 9 범위에 해당되는 숫자
     */
    public static List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
}
