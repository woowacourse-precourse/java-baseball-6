package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final List<Integer> threeDigitNumber = new ArrayList<>();
    public List<Integer> makeThreeDigitNum(){
        while (threeDigitNumber.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!threeDigitNumber.contains(randomNumber))
                threeDigitNumber.add(randomNumber);
        }
        return threeDigitNumber;
    }
}