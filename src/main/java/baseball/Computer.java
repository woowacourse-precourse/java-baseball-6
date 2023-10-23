package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final Integer NUMBER_LENGTH = 3;
    private List<Integer> computerNum = new ArrayList<>();

    public void setComputerNum() {
        computerNum.clear();
        while (computerNum.size() < NUMBER_LENGTH) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNum)) {
                computerNum.add(randomNum);
            }
        }
        System.out.println(computerNum);
    }

    public List<Integer> getComputerNum() {
        return computerNum;
    }
}
