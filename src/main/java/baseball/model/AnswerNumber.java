package baseball.model;

import static baseball.util.Constant.MAX_NUMBER_LENGTH;
import static baseball.util.Constant.MAX_NUMBER_RANGE;
import static baseball.util.Constant.MIN_NUMBER_RANGE;

import baseball.util.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class AnswerNumber {
    private String answerNumber;

    public  AnswerNumber() {
        getNewAnswerNumber();
    }

    public String getAnswerNumber() {
        return answerNumber;
    }

    public void getNewAnswerNumber() {
        LinkedHashSet<String> answerNumberList = new LinkedHashSet<String>();

        while (answerNumberList.size() < Constant.MAX_NUMBER_LENGTH) {
            answerNumberList.add(getStringRandomNumber());
        }
        this.answerNumber = String.join("", answerNumberList);
    }

    public static String getStringRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(Constant.MIN_NUMBER_RANGE, Constant.MAX_NUMBER_RANGE));
    }
}
