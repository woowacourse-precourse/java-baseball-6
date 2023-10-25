package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public List<Integer> createRandomNumber(){
        List<Integer> numbers = new ArrayList<>();

        while(numbers.size() < 3){
            int number = Randoms.pickNumberInRange(1, 9);
            if(numbers.contains(number)){
                continue;
            }else {
                numbers.add(number);
            }
        }
        return numbers;
    }
}
