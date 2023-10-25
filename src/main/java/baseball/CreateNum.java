package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateNum {
    public List<Integer> CreateNumber(){
        List<Integer> answer = new ArrayList<>(); //정답 숫자를 저장할 리스트
        while(answer.size()<3){
            int number = Randoms.pickNumberInRange(1,9);
            if(!answer.contains(number)){
                answer.add(number);
            }
        }
        return answer;
    }
}
