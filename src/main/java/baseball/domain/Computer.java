package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> makeRandomNumber(){
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int oneNumber = Randoms.pickNumberInRange(1,9);
            if(!randomNumber.contains(oneNumber)){
                randomNumber.add(oneNumber);
            }
        }
        return randomNumber;
    }

}
