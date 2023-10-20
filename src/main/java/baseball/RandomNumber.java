package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    List<Integer> number;
    public RandomNumber(){
        this.number = new ArrayList<>();
        while(this.number.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!this.number.contains(randomNumber)){
                this.number.add(randomNumber);
            }
        }
    }
}
