package baseball.Computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {
    ArrayList<Integer> answer = new ArrayList();

    void generateNum() {
        for (int i = 0; i < 3; i++) {
            answer.add(Randoms.pickNumberInRange(1, 9));
        }
    }


}
