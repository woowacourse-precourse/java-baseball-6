package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateRandomNumber {

    public List<Integer> getNumberList(){
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < 3){
            int pickupNumber = Randoms.pickNumberInRange(1,9);
            if(!numberList.contains(pickupNumber)){
                numberList.add(pickupNumber);
            }
        }
        return numberList;
    }


}
