package baseball.utils;

import static baseball.utils.SystemOutPut.printEndMsg;
import static baseball.utils.SystemOutPut.printRestartMsg;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class SystemSetting {
    public List<Integer> getRandamNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public boolean checkStrikeCount(int[] count) {
        if (count[0] != 3) {
            return true;
        }
        printEndMsg();
        printRestartMsg();
        return false;
    }


}
