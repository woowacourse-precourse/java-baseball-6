package baseball.player;

import baseball.common.Constants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer {
    private List<Integer> numbers = new ArrayList<>();

    public ComputerPlayer() {
        generateNumbers();
    }

    public void generateNumbers() {
        while(numbers.size() < Constants.maxNumDigit) {
            int randomNumber = Randoms.pickNumberInRange(Constants.startNum, Constants.lastNum);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber() {
        return numbers;
    }
}
