package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class Validation {


    public static void verifyUserNumber(String userNumber){
        verifyUserNumberLength(userNumber);
        verifyUserNumberRange(userNumber);
        verifyUserNumberDuplication(userNumber);
    }

    private static void verifyUserNumberLength(String userNumber) {
        if(userNumber.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    private static void verifyUserNumberRange(String userNumber){
        for(char eachNumber : userNumber.toCharArray()){
            if(eachNumber >= 1 && eachNumber <= 9){
                continue;
            }
            throw new IllegalArgumentException();
        }
    }

    private static void verifyUserNumberDuplication(String userNumber){
        Set<Character> count = new HashSet<>();
        for(int i=0; i<3; i++){
            count.add(userNumber.charAt(i));
        }
        if(count.size() != 3){
            throw new IllegalArgumentException();
        }
    }
}
