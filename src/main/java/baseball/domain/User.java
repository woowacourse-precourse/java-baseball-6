package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class User {


    private List<Integer>userNumber;

    public List<Integer> createUserNumber(String userNumber) {
        validateUserNumber(userNumber);
        return updateStringToListUser(userNumber);
    }


    public List<Integer> updateStringToListUser(String userNumber){
        this.userNumber = new ArrayList<>();
        for(char c : userNumber.toCharArray())
            this.userNumber.add((c-'0'));
        return this.userNumber;

    }


    public List<Integer> getUserNumber() {
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
            if (userNumber.charAt(i) - '0' < 1 || userNumber.charAt(i) - '0' > 9) throw new IllegalArgumentException();
        }
    }

    public void validateUniqueUserNumber(String userNumber) {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (userNumber.charAt(i) == userNumber.charAt(j)) throw new IllegalArgumentException();
            }
        }
    }


}
