package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Number {

    public Number() {
    }

    /**
     * 컴퓨터가 랜덤 3자리 숫자를 생성하는 메서드
     */
    public List<Integer> setRandomNumber() {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            computer.add(randomNumber);
        }

        return computer;
    }

}
