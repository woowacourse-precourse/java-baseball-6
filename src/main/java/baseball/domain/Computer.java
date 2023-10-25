package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MAX_NUMBER_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public List<Integer> createAnswerNumberList() {
        List<Integer> answerNumberList = new ArrayList<>();
        while (answerNumberList.size() < MAX_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!answerNumberList.contains(randomNumber)) {
                answerNumberList.add(randomNumber);
            }
        }
        System.out.println(answerNumberList.toString());
        return answerNumberList;
    }
}
