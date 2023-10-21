package baseball;

import java.util.List;

public class UserNumber {
    private final List<Integer> userNumber;

    public UserNumber(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    public List<Integer> getUserNumber(){
        return userNumber;
    }

}
