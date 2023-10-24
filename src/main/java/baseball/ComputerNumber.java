package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    public List<Integer> ComputerNumber() {
        List<Integer> conum = new ArrayList<>();
        while (conum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!conum.contains(randomNumber)){
                conum.add(randomNumber);
            }
        }
        return conum;
    }
}
