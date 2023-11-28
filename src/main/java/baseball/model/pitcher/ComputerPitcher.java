package baseball.model.pitcher;

import baseball.model.vo.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerPitcher implements Pitcher {

    // service
    @Override
    public BaseballNumber generate() {
        List<Integer> pitcherNumber = new ArrayList<>();
        while (pitcherNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!pitcherNumber.contains(randomNumber)) {
                pitcherNumber.add(randomNumber);
            }
        }
        return BaseballNumber.of(pitcherNumber);
    }
}
