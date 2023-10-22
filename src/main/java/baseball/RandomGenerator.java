package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    public String make(int length) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i: computer) {
            sb.append(i);
        }

        return sb.toString();
    }
}
