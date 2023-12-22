package baseball.Computer;



import static camp.nextstep.edu.missionutils.Randoms.*;
import static baseball.Constant.*;

import java.util.ArrayList;
import java.util.List;

public class ComputerServiceImpl implements ComputerService{

    @Override
    public List<Integer> settingComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < SIZE) {
            int randomNumber = pickNumberInRange(COMPUTER_MIN, COMPUTER_MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
