package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {

    private Number number;

    private Computer() {
    }

    public static Computer create() {
        return new Computer();
    }

    public void setNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        number = Number.create(computer);
    }

    public int[] judgeResult(Number userNumber) {
        List<Integer> computer = number.getNumberList();
        List<Integer> user = userNumber.getNumberList();
        int result[] = {0, 0}; // result[0] = strike, result[1] = ball
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computer.get(i), user.get(i))) {
                result[0]++;
            } else if (computer.contains(user.get(i))) {
                result[1]++;
            }
        }
        return result;
    }
}
