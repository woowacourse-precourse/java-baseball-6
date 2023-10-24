package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class ComputerNumber {

    private static final int MAX_NUMBER_LENGTH = 3;

    private String computerNumber;

    public ComputerNumber() {
        SetComputerNumber();
    }

    public void SetComputerNumber() {
        this.computerNumber = String.join("", generateNumber());
    }

    public Set<String> generateNumber() {
        Set<String> number = new HashSet<String>();
        while (number.size() < MAX_NUMBER_LENGTH) {
            number.add(String.valueOf(Randoms.pickNumberInRange(1, 9)));
        }
        return number;
    }

    public String getComputerNumber() {
        return computerNumber;
    }
}