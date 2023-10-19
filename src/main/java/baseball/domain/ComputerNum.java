package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ComputerNum {
    private List<Integer> number;

    public ComputerNum() {
        while(number.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNum)) {
                number.add(randomNum);
            }
        }
    }
}
