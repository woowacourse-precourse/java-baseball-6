package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerNumber {
    private List<Integer> computerNumber;

    public ComputerNumber() {
        computerNumber = new ArrayList<>();
        assignNumber();
    }

    private void assignNumber() {
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getNumber() {
        return Collections.unmodifiableList(computerNumber);
    }

}
