package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumbers = new ArrayList<>();

    public void setUserNumber(int userNumber) {
        String userNumberString = String.valueOf(userNumber);
        for (int i = 0; i < userNumberString.length(); i++) {
            int digit = Character.getNumericValue(userNumberString.charAt(i));
            userNumbers.add(digit);
        }
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
