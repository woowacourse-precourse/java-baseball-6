package baseball.model;
 /*
 * 컴퓨터_3자리 숫자를 랜덤으로 생성
 * */
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    public List<Integer> num_C() {
        List<Integer> computerNum = new ArrayList<>();

        while (computerNum.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNum)) {
                computerNum.add(randomNum);
            }
        }

        return computerNum;
    }
}