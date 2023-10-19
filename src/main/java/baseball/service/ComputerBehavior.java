package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;

public class ComputerBehavior {
    public List<Integer> generatedNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < LENGTH) {
            int getNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            while (computerNumbers.contains(getNumber)) {
                getNumber = Randoms.pickNumberInRange(MAX_NUMBER, MAX_NUMBER);
            }
            computerNumbers.add(getNumber);
        }
        return computerNumbers;
    }
}
