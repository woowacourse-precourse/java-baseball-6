package baseball.excpetion;

import java.util.HashSet;
import java.util.Set;

public class InputException {

    public void validNumberLength(String input){
        if(input.length()!=3){
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }
    }
    public void validNumberType(String input){
        String regExp = "[1-9]+";
        if(!input.matches(regExp)){
            throw new IllegalArgumentException("0을 제외한 숫자만 입력해주세요.");
        }
    }
    public void validDuplicateNumber(String input){
        Set<Character> number = new HashSet<>();
        for(int i=0; i<3; i++){
            number.add(input.charAt(i));
        }
        if(number.size()!=3){
            throw new IllegalArgumentException("중복되는 숫자를 입력하지 마세요.");
        }
    }
    public void validOption(String option){
        if(!option.equals("1") && !option.equals("2") ){
            throw new IllegalArgumentException("숫자 1 과 2에서 고르세요.");
        }
    }
}
