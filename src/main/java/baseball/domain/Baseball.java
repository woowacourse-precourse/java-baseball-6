package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private List<Integer> computerNum;

    public Baseball() {
        this.computerNum = pickComputerNum();
    }

    List<Integer> pickComputerNum() {
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
