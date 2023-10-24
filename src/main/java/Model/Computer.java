package Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class Computer {

    private String computerNumber;

    public Computer() {
        createComputerNumber();
    }

    private void createComputerNumber() {
        LinkedHashSet<String> computerCheck = new LinkedHashSet<>();
        while (computerCheck.size() < BaseballNumberConstants.INPUT_MAX_COUNTS) {
            computerCheck.add(randomNumberCreate());
        }
        this.computerNumber = String.join("", computerCheck);
    }

    private static String randomNumberCreate() {
        return Integer.toString(Randoms.pickNumberInRange(BaseballNumberConstants.INPUT_MIN,
                BaseballNumberConstants.INPUT_MAX));
    }

    public String getComputerNumber() {
        return computerNumber;
    }
}
