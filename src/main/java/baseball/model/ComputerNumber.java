package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static List<Integer> computerNumber;

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }
}
