package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class RandNum {

    List<Integer> numArr = new ArrayList<>();

    public void makeRandNum() {

        while (numArr.size() < 3) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            if (!numArr.contains(randNum)) {
                numArr.add(randNum);
            }
        }
        System.out.println(numArr); //출력 확인
    }

}
