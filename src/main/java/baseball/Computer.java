package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> genRandomNum(){
        List<Integer> computerNum = new ArrayList<>();
        while(computerNum.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNum.contains(randomNumber)){
                computerNum.add((randomNumber));
            }
        }
        return computerNum;
    }
}
