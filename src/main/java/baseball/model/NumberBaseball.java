package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseball {
    // 더 좋은 변수명 생각해보기
    private List<Integer> computerNum = new ArrayList<>();

    public NumberBaseball() {
        generateComputerNum();
    }

    private void generateComputerNum() {
        while(computerNum.size() < 3) {
            int randNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNum.contains(randNumber)) {
                computerNum.add(randNumber);
            }
        }
    }
}
