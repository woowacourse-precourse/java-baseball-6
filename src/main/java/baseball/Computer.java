package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int NUMBER_LENGTH = 3;
    private static final int DIGIT_MIN = 1;
    private static final int DIGIT_MAX = 9;
    int randomNumber;

    public Computer() {
    }

    public void setRandomNumber() {
        List<String> digitsList = getRandomDigits();
        randomNumber = joinDigitsTogether(digitsList);
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    private static List<String> getRandomDigits() {
        List<String> digitsList = new ArrayList<>();
        while(digitsList.size() < NUMBER_LENGTH) {
            String digit = getRandomDigit();
            if(!digitsList.contains(digit)) {
                digitsList.add(digit);
            }
        }
        return digitsList;
    }

    private static int joinDigitsTogether(List<String> digitsList) {
        return Integer.parseInt(String.join("", digitsList));
    }

    private static String getRandomDigit() {
        return String.valueOf(Randoms.pickNumberInRange(DIGIT_MIN, DIGIT_MAX));
    }
}