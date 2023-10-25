package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Number{
    private List<Integer> computerNum;

    public List<Integer> getComputerNum() {
        return computerNum;
    }

    public void createComputerNum() {
        computerNum = new ArrayList<>();
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
    }
}
