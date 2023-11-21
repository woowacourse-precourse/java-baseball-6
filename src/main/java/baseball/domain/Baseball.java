package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private List<String> computerNum;

    public Baseball() {
        this.computerNum = pickComputerNum();
    }

    private List<String> pickComputerNum() {
        List<String> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            String randomNum = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computerNum.contains(randomNum)) {
                computerNum.add(randomNum);
            }
        }
        return computerNum;
    }
}
