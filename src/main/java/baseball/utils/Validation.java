package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class Validation {


    public static void verifyUserNumber(String userNumber){
        verifyUserNumberLength(userNumber);
    }

    private static void verifyUserNumberLength(String userNumber) {
        if(userNumber.length() != 3){
            throw new IllegalArgumentException();
        }
    }
}
