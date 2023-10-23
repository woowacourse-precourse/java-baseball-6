package baseball.verifier;

import baseball.system.ExceptionMessage;

import java.util.HashSet;
import java.util.Set;

import static baseball.Application.NUM_DIGITS;

public class BaseBallNumVerifier implements Verifier {
    @Override
    public void check(String input) throws IllegalArgumentException {
        checkThreeDigits(input);
        checkOneToNine(input);
        checkDistinct(input);
    }

    private void checkThreeDigits(String input){
        if(input.length() != NUM_DIGITS){
            throw new IllegalArgumentException(ExceptionMessage.NOT_THREE_DIGITS);
        }
    }
    private void checkOneToNine(String input){
        if(!input.matches("^[1-9]+$")){
            throw new IllegalArgumentException(ExceptionMessage.NOT_ONE_TO_NINE);
        }
    }
    private void checkDistinct(String input){
        Set<Character> uniqueChars = new HashSet<>();
        for(char char_num : input.toCharArray()){
            if(!uniqueChars.add(char_num))//중복된 수를 넣으려고 하는 경우 예외처리
                throw new IllegalArgumentException(ExceptionMessage.NOT_DISTINCT);
        }
    }

}
