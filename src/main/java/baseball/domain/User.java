package baseball.domain;

import java.util.List;

public class User {


    private String userNumber;

    public User(String userNumber) {
        validateUserNumber(userNumber);
        this.userNumber = userNumber;
    }


    public String getUserNumber() {
        return this.userNumber;
    }

    public void validateUserNumber(String userNumber) {
        validateIsThreeUserNumber(userNumber);
        validateInRangeUserNumber(userNumber);
        validateUniqueUserNumber(userNumber);
    }

    public void validateIsThreeUserNumber(String userNumber) {
        if (userNumber.length() != 3) throw new IllegalArgumentException();
    }

    public void validateInRangeUserNumber(String userNumber) {
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) - '0' < 1 || userNumber.charAt(i) - '0' > 9) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateUniqueUserNumber(String userNumber) {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (userNumber.charAt(i) == userNumber.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }


}
