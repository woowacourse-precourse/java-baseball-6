package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RandomNumberPicker {
    List<Integer> randomNumbers = new ArrayList<>();

    public List<Integer> pickRandomNums(){
        while(randomNumbers.size()!=3){
            int randomNum = Randoms.pickNumberInRange(1, 9);

            if (randomNumbers.contains(randomNum)) {
                continue;
            }
            randomNumbers.add(randomNum);
        }

        return randomNumbers;
    }

}
