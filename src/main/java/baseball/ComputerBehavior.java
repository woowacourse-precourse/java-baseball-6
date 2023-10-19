package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerBehavior {
    public List<Integer> generatedNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int getNumber = Randoms.pickNumberInRange(1, 9);
            while (computerNumbers.contains(getNumber)) {
                getNumber = Randoms.pickNumberInRange(1, 9);
            }
            computerNumbers.add(getNumber);
        }
        return computerNumbers;
    }
}
