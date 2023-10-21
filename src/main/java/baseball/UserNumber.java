package baseball;

import java.util.List;

public class UserNumber {
    private static final int NUMBER_SIZE = 3;
    private final List<Integer> userNumber;

    public UserNumber(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    private void validateLength(List<Integer> userInputNumber){
        if(userInputNumber.size() != NUMBER_SIZE){
            throw new IllegalArgumentException();
        }
    }


    public List<Integer> getUserNumber(){
        return userNumber;
    }

}
