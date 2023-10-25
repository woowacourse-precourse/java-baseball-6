package main.java.baseball.UserValid;
import java.util.stream.Collectors;
import java.util.Set;

public class Validator {

    private static int MAX_INPUT_NUM = 987;
    private static int MIN_INPUT_NUM = 123;
    private static int MAX_LEN = 3;

    public static void CheckInputNumber(String userNum){
        CheckLength(userNum);
        CheckNumber(userNum);
        CheckDuplicate(userNum);
    }

    public static void CheckNumber(String userNum){
        try {
            int number = Integer.parseInt(userNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    public static void  CheckDuplicate(String userNum){
        int[] userNumArr = userNum.chars()
                .map(Character::getNumericValue)
                .toArray();

        Set<Integer> userNumSet = userNum.chars()
                .map(Character::getNumericValue)
                .boxed() // Box the int values to Integer objects
                .collect(Collectors.toSet());

        if(userNumArr.length != userNumSet.size()){
            throw new IllegalArgumentException();
        }
    }
    public static void  CheckLength(String userNum){
        int L = userNum.length();
        if (L > MAX_LEN || L<MAX_LEN) {
            throw new IllegalArgumentException();
        }
    }
}
