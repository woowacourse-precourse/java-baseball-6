package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> userNumber;

    public User() {
        this.userNumber = new ArrayList<>();
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void storeUserNumber(String number) {
        userNumber.clear();
        for (int i = 0; i < 3; i++) {
            userNumber.add(Character.getNumericValue(number.charAt(i)));
        }
    }

}
