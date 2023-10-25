package baseball.error;

import baseball.massage.ErrorMassage;

import java.util.HashSet;
import java.util.Set;

public class InputError {
    public static void checkUserNumber(String input){
        if(input.length()!= 3 ) {
            throw new IllegalArgumentException(ErrorMassage.NOT_THREE_DIGIT.getErrorMessage());
        }
        if(!input.matches("[1-9]+")){
            throw new IllegalArgumentException(ErrorMassage.NOT_ONLY_NUMBER.getErrorMessage());
        }
        if(checkDuplicate(input)){
            throw new IllegalArgumentException((ErrorMassage.NOT_DUPLICATE_NUMBER.getErrorMessage()));
        }
    }

    public static boolean checkDuplicate(String input){
        char[] digits = input.toCharArray();
        Set<Character> digitSet = new HashSet<>();

        for (char digit : digits) {
            if (!digitSet.add(digit)) {
                return true;
            }
        }
        return false;
    }
}
