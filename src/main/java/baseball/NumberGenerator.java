package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Constant.*;

public class NumberGenerator {

    public static List<Integer> generateAnswerNumbers(){
        /* 1 ~ 9 사이의 숫자로 구성된 3자리 숫자 임의 생성 */
        List<Integer> answerNumberList = new ArrayList<>();

        /* 3자리 숫자 구성될 때 까지 반복 */
        while(answerNumberList.size() < NUMBER_SIZE){

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!answerNumberList.contains(randomNumber)){
                answerNumberList.add(randomNumber);
            }

        }
        return answerNumberList;
    }
}
