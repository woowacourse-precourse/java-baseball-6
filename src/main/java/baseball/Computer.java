package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNum;

    public List<Integer> getComputerNum() {
        return computerNum;
    }

    public void createComputerNum() {
        computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        Number number = new Number(computerNum);
        try {
            number.validate();
        } catch (IllegalArgumentException e) {
            createComputerNum();
        }
    }
}
