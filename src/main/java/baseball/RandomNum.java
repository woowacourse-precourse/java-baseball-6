package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNum {

    private List<Integer> num;

    public RandomNum() {
        num = createNum();
    }

    private List<Integer> createNum() {
        List<Integer> answer = new ArrayList<>();
        while(answer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public Integer getNum(int index){
        return num.get(index);
    }
}
