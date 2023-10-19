package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private static final int NUMBER_LENGTH = 3;
    private final List<Integer> userNumber = new ArrayList<>();

    public void setUserNumber(String number){
        initUserNumber();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            userNumber.add(Integer.valueOf(number.charAt(i) - '0'));
        }
    }

    private void initUserNumber() {
        if (userNumber.size() == NUMBER_LENGTH) {
            userNumber.clear();
        }
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }
}
