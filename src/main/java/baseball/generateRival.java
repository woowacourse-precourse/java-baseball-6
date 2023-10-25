package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class generateRival {
    static int Max_Val = 3;

    static List<Integer> RivalNumber() {
        List<Integer> computer = new ArrayList<Integer>();

        while (computer.size() < Max_Val) {
            int RandNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(RandNum))
                computer.add(RandNum);

        }
        return computer;
    }
}
