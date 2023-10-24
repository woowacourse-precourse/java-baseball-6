package baseball.player;

import baseball.common.Constants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer {
    private List<Integer> computer = new ArrayList<>();

    public ComputerPlayer() {
        generateNumbers();
    }

    public void generateNumbers() {
        while(computer.size() < Constants.numDigit) {
            int randomNumber = Randoms.pickNumberInRange(Constants.startNum, Constants.lastNum);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber() {
        return computer;
    }
}
