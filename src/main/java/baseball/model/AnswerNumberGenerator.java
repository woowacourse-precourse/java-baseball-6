package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class AnswerNumberGenerator {

    ArrayList<Integer> answerNumberList = new ArrayList<Integer>(3);

    public ArrayList<Integer> GetAnswerNumber() {
        while (GetAnswerNumber().size() < MAX_NUMBBER_LENGTH) {
            isNumberInList((Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE)));
        }
        return answerNumberList;
    }

    public void isNumberInList(int number) {
        if (answerNumberList.contains(number)) {
        }
        answerNumberList.add(number);
    }
}
