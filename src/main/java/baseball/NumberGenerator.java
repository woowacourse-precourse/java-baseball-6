package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Integer> generateNumber(){
        List<Integer> numbers = new ArrayList<>();

        while(numbers.size() < 3){
            int randomNum = Randoms.pickNumberInRange(1, 9);

            if(numbers.contains(randomNum)) continue;

            numbers.add(randomNum);
        }

        return numbers;
    }

}
