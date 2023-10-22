package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNum;

    Computer() {
        this.randomNum = new ArrayList<>();
    }

    public List<Integer> getRandomNum() {
        return List.copyOf(randomNum);
    }

    public void generateRandomNum() {
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
    }
}
