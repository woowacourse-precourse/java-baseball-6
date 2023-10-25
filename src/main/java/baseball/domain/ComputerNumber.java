package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private final static int NUMBER_SIZE = 3;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;

    private List<Integer> computerNumber = new ArrayList<>();

    public ComputerNumber() {
        while (computerNumber.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computerNumber.contains(randomNumber)) {
                this.computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
