package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public Computer() {
    }

    int randomNum;

    public void setRandomNum() {
        List<String> digitsList = getRandomDigits();
        randomNum = joinDigitsTogether(digitsList);
    }

    public int getRandomNum() {
        return randomNum;
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