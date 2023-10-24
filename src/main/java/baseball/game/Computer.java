package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public String randomNum;

    public void setRandomNum() {
        List<Integer> list = new ArrayList<>();
        randomNum = "";
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        for (Integer item : list) {
            randomNum += Integer.toString(item);
        }
    }
}
