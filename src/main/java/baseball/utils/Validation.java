package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class Validation {


    public static void verifyUserNumber(String userNumber){
        verifyUserNumberLength(userNumber);
        verifyUserNumberRange(userNumber);
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
}
