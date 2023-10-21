package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;

public abstract class Validator {
    public abstract void validate(String input);
    
    protected void validateSize(String numbers,int size){
        if (numbers.length()!=size){
            throw new IllegalArgumentException("값이 "+size+"자리여야 합니다.");
        }
    }

    protected void validateType(String numbers,String regex){
        if (!numbers.matches(regex)){
            throw new IllegalArgumentException("값이 올바르지 않습니다.");
        }
    }

    protected void validateUnique(String numbers){
        if(new HashSet<>(Arrays.asList(numbers.split(""))).size()!=3){
            throw new IllegalArgumentException("값의 중복은 없어야 합니다.");
        }
    }
}
