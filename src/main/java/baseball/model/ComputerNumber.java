package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class ComputerNumber {

    private String computerNumber;

    public ComputerNumber() {
        setGameClearNumber();
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    private void setGameClearNumber() {
        LinkedHashSet<String> computerNumberCheck = new LinkedHashSet<>();
        while (computerNumberCheck.size() < 3) {
            computerNumberCheck.add(getRandomNumber());
        }

        this.computerNumber = String.join("", computerNumberCheck);
    }

    private String getRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(1, 9));
    }
}
