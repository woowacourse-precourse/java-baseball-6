package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {
    private static final String NUMBERS_REGEX="[0-9]+";
    private static final String CONTINUE_REGEX="[1-2]+";

    public void validateNumbers(String numbers){
        validateSize(numbers,3);
        validateType(numbers,NUMBERS_REGEX);
        validateUnique(numbers);
    }

    public void validateContinue(String input){
        validateSize(input,1);
        validateType(input,CONTINUE_REGEX);
    }

    private void validateSize(String numbers,int size){
        if (numbers.length()!=size){
            throw new IllegalArgumentException("값이 "+size+"자리여야 합니다.");
        }
    }

    private void validateType(String numbers,String regex){
        if (!numbers.matches(regex)){
            throw new IllegalArgumentException("값이 올바르지 않습니다.");
        }
    }

    private void validateUnique(String numbers){
        if(new HashSet<>(Arrays.asList(numbers.split(""))).size()!=3){
            throw new IllegalArgumentException("값의 중복은 없어야 합니다.");
        }
    }
}
