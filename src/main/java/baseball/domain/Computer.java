package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int COMPUTER_START_NUMBER = 1;
    private static final int COMPUTER_END_NUMBER = 9;

    List<Integer> computerNumber;

    public List<Integer> randomComputerNumber() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(COMPUTER_START_NUMBER, COMPUTER_END_NUMBER);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }


}
