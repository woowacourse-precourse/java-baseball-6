package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> randomNum() {
        List<Integer> com = new ArrayList<>();
        while (com.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!com.contains(randomNum)) {
                com.add(randomNum);
            }
        }
        //       System.out.println(com.toString());
        return com;
    }
}
