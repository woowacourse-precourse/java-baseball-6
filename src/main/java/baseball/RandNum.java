package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class RandNum {

    public List makeRandNum() {

        List<Integer> numArr = new ArrayList<>();
        while (numArr.size() < 3) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            if (!numArr.contains(randNum)) {
                numArr.add(randNum);
            }
        }
        //System.out.println(numArr); //화면 출력 디버깅용
        return numArr;
    }

}
