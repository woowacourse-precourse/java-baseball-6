package baseball.Computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {
    ArrayList<Integer> answer = new ArrayList();

    void generateNum() {
        while (answer.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(num)) {
                answer.add(num);
            }
        }
    }


}
