package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public Computer() {
    }

    int randomNumber;

    public void setRandomNumber() {
        List<String> digitsList = getRandomDigits();
        randomNumber = joinDigitsTogether(digitsList);
    }

    public int getRandomNumber() {
        return randomNumber;
    }


    private static int joinDigitsTogether(List<String> digitsList) {
        return Integer.parseInt(String.join("", digitsList));
    }

    private static String getRandomDigit() {
        return String.valueOf(Randoms.pickNumberInRange(1, 9));
    }

    private static List<String> getRandomDigits() {
        List<String> digitsList = new ArrayList<>();
        while(digitsList.size() < 3) {
            String digit = getRandomDigit();
            if(!digitsList.contains(digit)) {
                digitsList.add(digit);
            }
        }
        return digitsList;
    }

}