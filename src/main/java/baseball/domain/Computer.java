package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> createAnswerNumberList(){
        List<Integer> answerNumberList = new ArrayList<>();
        while (answerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberList.contains(randomNumber)) {
                answerNumberList.add(randomNumber);
            }
        }
        System.out.println(answerNumberList.toString());
        return answerNumberList;
    }
}
