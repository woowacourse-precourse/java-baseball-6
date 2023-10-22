package baseball;

import static baseball.Constant.MAX_DIGIT;
import static baseball.Constant.MAX_NUM;
import static baseball.Constant.MIN_NUM;

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
        while (randomNum.size() < MAX_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
    }
}
