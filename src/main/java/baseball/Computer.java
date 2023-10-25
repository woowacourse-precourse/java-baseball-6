package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer extends Number {
    public List<Integer> createComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MINRANGE, MAXRANGE);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        try {
            validate(computerNum);
        } catch (IllegalArgumentException e) {
            createComputerNum();
        }
        return computerNum;
    }
}
