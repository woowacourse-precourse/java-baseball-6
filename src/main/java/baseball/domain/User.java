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

    public void validateDuplicated(String input){
        if (input.length() != input.chars().distinct().count())
            throw new IllegalArgumentException();
    }

    public void validateIncludedZreo(String input){
        if(input.contains("0"))
            throw new IllegalArgumentException();
    }

}
