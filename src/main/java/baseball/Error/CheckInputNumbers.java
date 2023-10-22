package baseball.Error;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckInputNumbers {

    public static void checkLength(String input){
        if(input.length() != 3){
            throw new IllegalArgumentException("잘못된 길이의 값이 입력되었습니다.");
        }
    }

    public static List<Integer> checkNumber(String input){
        List<Integer> userInput = new ArrayList<>();
        for(int i=0; i<input.length(); i++){
            char inputChar = input.charAt(i);
            if(!('0' <= inputChar && inputChar <= '9')){
                throw new IllegalArgumentException("숫자 외의 다른 값이 입력되었습니다.");
            }

            userInput.add((int)inputChar-48);
        }
        return userInput;
    }

    public static void checkDuplicate(List<Integer> input){
        Set<Integer> numSet = new HashSet<>(input);

        if(numSet.size()!= input.size()){
            throw new IllegalArgumentException("중복된 값이 입력되었습니다.");
        }
    }
}
