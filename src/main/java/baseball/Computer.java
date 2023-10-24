package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    Validator validator= new Validator();
    private static final List<Integer> baseballNum = new ArrayList<>();
    public List<Integer>createValidBaseballNum(){
        while(baseballNum.size()<3){
            int invalidNum = Randoms.pickNumberInRange(1, 9);
            if(!validator.validNumNotInList(invalidNum,baseballNum)){
                continue;
            }
            baseballNum.add(invalidNum);
        }
        return baseballNum;
    }
}
