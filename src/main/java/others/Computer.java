package others;

import static others.Constant.maxRange;
import static others.Constant.minRange;
import static others.Constant.numberOfNumbers;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> computerGenerateNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < numberOfNumbers) {
            int randomNumber = Randoms.pickNumberInRange(minRange, maxRange);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
