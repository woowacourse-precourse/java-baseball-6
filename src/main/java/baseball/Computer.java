package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Validator.isContainZero;
import static baseball.Validator.isDigitsUnique;

public class Computer {
    private String randomNumber;
    private final int startRange = 100;
    private final int endRange = 999;

    public String getRandomNumber() {
        return randomNumber;
    }

    public void generateRandomNumber() {
        do {
            randomNumber = Integer.toString(Randoms.pickNumberInRange(startRange, endRange));
        } while (!isDigitsUnique(randomNumber) && !isContainZero(randomNumber));
    }


}
