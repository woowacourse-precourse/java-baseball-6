package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import static baseball.Constants.*;

public class AnswerNumberGenerator {


    List<Integer> answerNumberList = new ArrayList<>();

    public List<Integer> getAnswerNumberList() {
        while (answerNumberList.size() < NUMBER_SIZE) {
            int singleDigitNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            if (!answerNumberList.contains(singleDigitNumber)) {
                answerNumberList.add(singleDigitNumber);
            }
        }
        return answerNumberList;
    }

}
