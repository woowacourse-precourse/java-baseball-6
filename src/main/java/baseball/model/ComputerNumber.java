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
            addNumber(randomNumber);
        }
    }

    private void addNumber(int randomNumber) {
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    public List<Integer> getNumber() {
        return Collections.unmodifiableList(computerNumber); //불면성 보장을 위해 unmodifiableList 호출
    }

}
