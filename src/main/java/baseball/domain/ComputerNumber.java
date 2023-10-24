package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.consts.NumberConst.*;

public class ComputerNumber {
    public List<String> createComputerNumber(){
        List<String> numbers = new ArrayList<>();
        while(numbers.size() < BASEBALL_SIZE){
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER));
            if(!numbers.contains(randomNumber))
                numbers.add(randomNumber);
        }
        return numbers;
    }
}
