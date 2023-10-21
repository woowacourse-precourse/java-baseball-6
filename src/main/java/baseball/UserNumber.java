package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserNumber {
    private static final int NUMBER_SIZE = 3;
    private final List<Integer> userNumber = new ArrayList<>();

    public UserNumber(String userNumber) {

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

    private void validateDuplication(String userInputNumber){
        Set<Character> set = new HashSet<>();
        for(char ch : userInputNumber.toCharArray()){
            if(set.contains(ch)){
                throw new IllegalArgumentException();
            }
            set.add(ch);
        }
    }

    private void convertInputStringToList(String userInputNumber){
        for(char ch: userInputNumber.toCharArray()){
            userNumber.add(Character.getNumericValue(ch));
        }
    }

    public List<Integer> getUserNumber(){
        return userNumber;
    }

}
