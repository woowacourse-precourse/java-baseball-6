package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int LENGTH_OF_NUMBER = 3;

    int randomNum;

    public void setRandomNumber() {
        List<String> integerList = getRandomIntegers();
        randomNum = joinIntegers(integerList);
    }

    public int getRandomNumber() {
        return randomNum;
    }


    private static int joinIntegers(List<String> integerList) {
        return Integer.parseInt(String.join("", integerList));
    }

    private static String getRandomInteger() {
        return String.valueOf(Randoms.pickNumberInRange(1, 9));
    }

    private static List<String> getRandomIntegers() {
        List<String> integerList = new ArrayList<>();
        while (integerList.size() < LENGTH_OF_NUMBER) {
            String number = getRandomInteger();
            if (!integerList.contains(number)) {
                integerList.add(number);
            }
        }
        return integerList;
    }

}