package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class User {


    private List<Integer>userNumber;

    public List<Integer> createUserNumber(String userNumber) {
        updateStringToListUser(userNumber);
        validateUserNumber();
        return this.userNumber;
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

    public void validateUserNumber() {
        validateIsThreeUserNumber();
        validateInRangeUserNumber();
        validateUniqueUserNumber();
    }

    public void validateIsThreeUserNumber() {
        if (userNumber.size() != 3) throw new IllegalArgumentException();
    }

    public void validateInRangeUserNumber() {
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i) < 1 || userNumber.get(i) > 9) throw new IllegalArgumentException();
        }
    }

    public void validateUniqueUserNumber() {
        userNumber.stream().distinct();
        if(userNumber.size() != userNumber.stream().distinct().count())
            throw new IllegalArgumentException();
    }


}
