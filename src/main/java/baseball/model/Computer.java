package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final String computerNumber;

    private Computer(String computerNumber) {
        this.computerNumber = computerNumber;
    }

    public static Computer generateRandomNumber() {
        String randNum = String.valueOf(Randoms.pickNumberInRange(1, 9))
                + Randoms.pickNumberInRange(0, 9)
                + Randoms.pickNumberInRange(0, 9);
        return new Computer(randNum);
    }

    public String getComputerNumber() {
        return computerNumber;
    }
}
