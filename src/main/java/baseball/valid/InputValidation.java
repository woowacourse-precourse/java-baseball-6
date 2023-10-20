package baseball.valid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidation {

    public static void validateInputNum(String input){
        validateOnlyNum(input);
        validateAllDifferentNumAndSize(input);
        validateNumRange(input);
    }

    private static void validateOnlyNum(String input){
        String reg = "^[0-9]*$";
        if(!input.matches(reg)){
            throw new IllegalArgumentException();
        }
    }

    private static void validateAllDifferentNumAndSize(String input){
        if(input.chars().count() != 3 || input.chars().distinct().count() != 3){
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumRange(String input){
        if(!input.chars().map(letter -> letter - '0').boxed().allMatch(num ->num >=1 && num <= 9)){
            throw new IllegalArgumentException();
        }
    }

    public static void validateRestartNum(String input){
        if(!input.equals("1") && !input.equals("2")){
            throw new IllegalArgumentException();
        }

    }

}
