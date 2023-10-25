package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomComputerPickNum = new ArrayList<>();

    public void randomComputerPick() {
        randomComputerPickNum.clear();
        while (randomComputerPickNum.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomComputerPickNum.contains(randomNum)) {
                randomComputerPickNum.add(randomNum);
            }
        }
    }

    public List<Integer> getRandomComputerPickNum() {
        return randomComputerPickNum;
    }
}
