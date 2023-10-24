package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;

public class RandomNumberGenerator {
    public String makeRandomNumber(){
        String answer ="";

        HashSet<Integer> set = new HashSet<>();

        //중복되지 않은 세자리 수가 될 때 까지 Set에 집어넣는다.
        while (set.size() !=3){
            int number = Randoms.pickNumberInRange(1,9);
            set.add(number);
        }

        //Set에 있는 숫자 String으로 변환
        StringBuilder sb = new StringBuilder();
        for(Integer number : set){
            sb.append(number.toString());
        }
        answer = sb.toString();
        return answer;
    }
}
