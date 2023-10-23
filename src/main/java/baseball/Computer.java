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
        int number = 0;
        do {
            number = Randoms.pickNumberInRange(startRange, endRange);
        } while(!isUniqueDigits(number));
        randomNumber = Integer.toString(number);
    }

    private boolean isUniqueDigits(int number){
        int hundredDigit = number /100;
        int tenDigit = (number / 10) % 10;
        int oneDigit = number % 10;

        return hundredDigit != tenDigit || tenDigit != oneDigit || oneDigit != hundredDigit;
    }
}
