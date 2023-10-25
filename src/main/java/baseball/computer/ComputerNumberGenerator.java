package baseball.computer;

import baseball.game.GameConstants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator extends GameConstants {
    public List<Integer> generateNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_VALUE, MAX_NUMBER_VALUE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
