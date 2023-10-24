package baseball.func;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class MakeComputerNumber {
    public List copmputerNumber() {
        List<Integer> computerScore = new ArrayList<>();

        while (computerScore.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computerScore.contains(randomNum)) {
                computerScore.add(randomNum);
            }
        }

        return computerScore;
    }
}
