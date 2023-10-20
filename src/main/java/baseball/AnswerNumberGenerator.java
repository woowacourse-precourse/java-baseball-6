package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerNumberGenerator {

    private final static int MAX_NUMBER_SIZE = 3;
    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 9;


    List<Integer> answerNumberList = new ArrayList<>();

    public List<Integer> getAnswerNumberList() {
        while (answerNumberList.size() < MAX_NUMBER_SIZE) {
            int singleDigitNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            if (!answerNumberList.contains(singleDigitNumber)) {
                answerNumberList.add(singleDigitNumber);
            }
        }
        return answerNumberList;
    }

}
