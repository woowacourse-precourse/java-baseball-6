package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    private static final int NUMBER_SIZE = 3;
    private final List<Integer> userNumber = new ArrayList<>();

    public UserNumber(String userNumber) {
        // this.userNumber = userNumber;
    }

    private void validateLength(String userInputNumber){
        if(userInputNumber.length() != NUMBER_SIZE){
            throw new IllegalArgumentException();
        }
    }

    private void validateDigit(String userInputNumber){
        for(char ch : userInputNumber.toCharArray()){
            if(!Character.isDigit(ch) || ch <'1' || ch >'9'){
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getUserNumber(){
        return userNumber;
    }

}
