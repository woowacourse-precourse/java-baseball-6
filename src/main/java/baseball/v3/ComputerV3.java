package baseball.v3;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerV3 implements SetNumV3{
    public List<Integer> setNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }
}
