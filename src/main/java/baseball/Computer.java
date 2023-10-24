package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public String number; // 컴퓨터의 서로 다른 3자리의 수

    // 서로 다른 임의의 수 3개를 선택한다.
    public void setNumber() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        number = "";
        for (Integer item : list) {
            number += Integer.toString(item);
        }
    }
}
