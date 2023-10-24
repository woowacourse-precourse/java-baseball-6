package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserGuessNumber {

    private final List<Integer> userGuessNumber;

    public UserGuessNumber(String guessNumberString) {
        userGuessNumber = numberStringToList(guessNumberString);
    }

    private List<Integer> numberStringToList(String numberString) {
        int numberInt = Integer.parseInt(numberString);
        List<Integer> intList = new ArrayList<Integer>();
        while (numberInt > 0) {
            intList.add(0, numberInt % 10);
            numberInt /= 10;
        }
        return intList;
    }

    public int size() {
        return userGuessNumber.size();
    }

    public int getNumber(int index) {
        return userGuessNumber.get(index);
    }
}
