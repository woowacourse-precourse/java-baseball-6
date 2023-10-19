package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userBaseballNumber = new ArrayList<>();

    public List<Integer> getUserBasebsallNumber(){
        return userBaseballNumber;
    }

    public void setUserBasebsallNumber(String input){
//        userBaseballNumber = validateInput(input);
    }

//    private List<Integer> validateInput(String input) {
//    }

    public void validateLength(String input){
        if(input.length() != 3)
            throw new IllegalArgumentException();
    }

}
