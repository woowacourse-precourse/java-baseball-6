package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class randomNumberGenerator {

    public static List<Integer> generateComputer() {
        List<Integer> computer = new ArrayList<>(3);
        int num = Randoms.pickNumberInRange(1, 9);
        computer.add(num);
        for (int i=1; i<3; i++) {
            while (num == computer.get(i-1)) {
                num = Randoms.pickNumberInRange(1, 9);
            }
            computer.add(num);
        }
        return computer;
    }
}
