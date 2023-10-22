package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private String randomNumber;
    private final int startRange = 100;
    private final int endRange = 999;

    public String getRandomNumber() {
        return randomNumber;
    }

    public void generateRandomNumber() {
        randomNumber = Integer.toString(Randoms.pickNumberInRange(startRange, endRange));
    }
}
