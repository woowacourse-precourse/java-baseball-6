package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNum {
    public List<Integer> ComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int userNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(userNum)) {
                computer.add(userNum);
            }
        }
        return computer;
    }
}