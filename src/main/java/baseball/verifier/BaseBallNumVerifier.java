package baseball.verifier;

import java.util.HashSet;
import java.util.Set;

import static baseball.Application.NUM_DIGITS;

public class BaseBallNumVerifier implements Verifier {
    @Override
    public void check(String input) throws IllegalArgumentException {
        checkThreeDigits(input);
        checkNumeric(input);
        checkDistinct(input);
    }

    private void checkThreeDigits(String input){
        if(input.length() != NUM_DIGITS){
            throw new IllegalArgumentException("3개의 수를 입력하지 않았습니다.");
        }
    }
    private void checkNumeric(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1~9사이 수가 아닌 값을 입력하였습니다.");
        }
    }
    private void checkDistinct(String input){
        Set<Character> uniqueChars = new HashSet<>();
        for(char char_num : input.toCharArray()){
            if(!uniqueChars.add(char_num))//중복된 수를 넣으려고 하는 경우 예외처리
                throw new IllegalArgumentException("중복된 수를 입력하였습니다.");
        }
    }

}
