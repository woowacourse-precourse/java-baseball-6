package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> systemNumber = new ArrayList<>();
        while (systemNumber.size() < 3) {
            Integer number = Randoms.pickNumberInRange(0, 9);
            if (!systemNumber.contains(number)) {
                systemNumber.add(number);
            }
        }


    }
}
