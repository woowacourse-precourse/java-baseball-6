package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Computer {

    /**
     * 3자리 무작위 숫자 생성
     * @return
     */
    public List<Integer> createAnswer(){
        List<Integer> answer = new ArrayList<>();

        while (answer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!answer.contains(randomNumber)){
                answer.add(randomNumber);
            }
        }

        return answer;
    }


}
