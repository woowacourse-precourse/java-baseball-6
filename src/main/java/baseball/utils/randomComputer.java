package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class randomComputer {

    private String computerRandomNumber;

    public randomComputer() {
        setComputerRandomNumber();
    }

    public String getComputerRandomNumber() {
        return computerRandomNumber;
    }

    public void setComputerRandomNumber() {
        LinkedHashSet<String> computerNumber = new LinkedHashSet<String>();
        while (computerNumber.size() < 3) {
            computerNumber.add(getComputerRandom());
        }

        this.computerRandomNumber = String.join("", computerNumber);
    }

    public static String getComputerRandom() {
        return Integer.toString(Randoms.pickNumberInRange(1, 9));
    }
}
