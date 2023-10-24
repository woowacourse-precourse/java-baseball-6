package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    public List<Integer> getComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Constant.gameNumberLength) {
            int randomNumber = Randoms.pickNumberInRange(Constant.pickNumberMin, Constant.pickNumberMax);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}