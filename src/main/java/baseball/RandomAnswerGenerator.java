package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomAnswerGenerator implements AnswerGenerator {
    @Override
    public List<Integer> generate() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            addNonDuplicatedNumber(answer);
        }
        return answer;
    }

    private static void addNonDuplicatedNumber(List<Integer> answer) {
        int number = Randoms.pickNumberInRange(1, 9);
        if (!answer.contains(number)) {
            answer.add(number);
        }
    }
}
