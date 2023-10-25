package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;


public class RandNum {

    public void makeRandNum(){
        List<Integer> numArr = new ArrayList<>();

        while (numArr.size() < 3) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            if (!numArr.contains(randNum)) {
                numArr.add(randNum);
            }
        }
        System.out.println(numArr); //출력 확인
    }

}
