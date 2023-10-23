package main.java.baseball.UserValid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.zip.CheckedInputStream;

public class Validator {

    private static int MAX_INPUT_NUM = 987;
    private static int MIN_INPUT_NUM = 123;
    private static int MAX_LEN = 3;

    public static void main(String[] args){
        CheckInputNumber("133");
    }
    public static void CheckInputNumber(String userNum){
        CheckLength(userNum);
        CheckNumber(userNum);
        CheckDuplicate(userNum);
    }

    private static void CheckNumber(String userNum){
        int checkIntNUm;
        try {
            checkIntNUm = Integer.parseInt(userNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    private static void  CheckDuplicate(String userNum){
        List<String> userNumList = Arrays.asList(userNum);
        // Set 으로 변환
        Set<String> userNumSet = new HashSet<>(userNumList);

        if(userNumSet.size()!= userNumList.size()){
            throw new IllegalArgumentException();
        }
    }
    private static void  CheckLength(String userNum){
        if (userNum.length() != MAX_LEN) {
            throw new IllegalArgumentException();
        }
    }
}
