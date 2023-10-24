package baseball;

import java.util.HashSet;
import java.util.Set;

public class ErrorExcept {
    public boolean ErrorIllegal(String input){

            if(!input.matches("\\d+") || input.length() >3 || input.length() < 3){
                throw new IllegalArgumentException("입력된 값이 숫자가 아니거나 3글자가 아닙니다.");
            }

            Set<Character> digitSet = new HashSet<>();
            for(char digit : input.toCharArray()){
                if(!digitSet.add(digit)){
                    throw new IllegalArgumentException("중복된 숫자가 있습니다.");
                }
            }


        return true;
    }
}
