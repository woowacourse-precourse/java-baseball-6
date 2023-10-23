package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Validator.isUniqueDigits;

public class Computer {
    private String randomNumber;
    private final int startRange = 100;
    private final int endRange = 999;

    public String getRandomNumber() {
        return randomNumber;
    }

    public void generateRandomNumber() {
        int number = 0;
        do {
            number = Randoms.pickNumberInRange(startRange, endRange);
        } while(!isUniqueDigits(number));
        randomNumber = Integer.toString(number);
    }


}
