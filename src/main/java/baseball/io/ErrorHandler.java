package baseball.io;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.regex.Pattern;

public class ErrorHandler {

    // only for testing
    public static void main(String[] args) {
        checkRepeat("1233");
    }


    public static final String RE_NUMBER = "^[1-9]+$"; // Doesn't include 0

    public static void checkNumber(String userInput){
        if (!Pattern.matches(RE_NUMBER, userInput)){
            throw new IllegalArgumentException("Error! 1~9까지만 가능 합니다");
        }
    }

    public static void checkLength(String userInput){
        if(userInput.length() != 3) {
            throw new IllegalArgumentException("Error! 입력값은 3자리여야 합니다");
        }
    }
    public static void checkRepeat(String userInput){
        List<Integer> list = Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).boxed().toList();
        for (Integer i: list){
            if (Collections.frequency(list,i) > 1){
                throw new IllegalArgumentException("Error! 각자릿수는 unique 해야 합니다");
            };
        }

    }
}
