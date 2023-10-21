package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserNumber {
    private static final int NUMBER_SIZE = 3;
    private final List<Integer> userNumber = new ArrayList<>();

    public UserNumber(String userNumber) {
        validateLength(userNumber);
        validateDigit(userNumber);
        validateDuplication(userNumber);
        convertInputStringToList(userNumber);
    }

    private void validateLength(String userInputNumber){
        if(userInputNumber.length() != NUMBER_SIZE){
            throw new IllegalArgumentException("입력 숫자의 길이가 3이 아닙니다.");
        }
    }

    private void validateDigit(String userInputNumber){
        for(char ch : userInputNumber.toCharArray()){
            if(!Character.isDigit(ch) || ch <'1' || ch >'9'){
                throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
            }
        }
    }

    private void validateDuplication(String userInputNumber){
        Set<Character> set = new HashSet<>();
        for(char ch : userInputNumber.toCharArray()){
            if(set.contains(ch)){
                throw new IllegalArgumentException("입력값에 중복된 값이 있습니다.");
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
