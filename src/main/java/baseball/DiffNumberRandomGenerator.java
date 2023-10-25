package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class DiffNumberRandomGenerator implements RandomGenerator {
    public String make(int length) {
        if (length >= 10) {
            throw new InputMismatchException("9자 이상을 생성할 수 없습니다");
        }

        if (length <= 0) {
            throw new InputMismatchException("길이 1이상만 생성할 수 있습니다");
        }

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
