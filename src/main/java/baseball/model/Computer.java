package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private String computerNumber;

    public String generateRandomNumber() {
        return String.valueOf(Randoms.pickNumberInRange(1, 9))
                + Randoms.pickNumberInRange(0, 9)
                + Randoms.pickNumberInRange(0, 9);
    }
}
