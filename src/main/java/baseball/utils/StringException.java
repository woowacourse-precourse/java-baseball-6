package baseball.utils;

import baseball.Exception.DepulicatedException;
import baseball.Exception.NumberOfInputException;
import baseball.Exception.ReplayInputException;

import java.util.Arrays;

import static java.util.Arrays.stream;

public class StringException {

    public static void checkException(String arr){
        checkDuplicated(arr);
        checkInputZeroException(arr);
        checkNumberOfInputException(arr);
        // checkInputTypeException(arr);
    }
    public static void checkReplayInputException(int a) {
        if (a != 1 && a!= 2) throw new ReplayInputException();
    }
    private static void checkDuplicated(String arr) {
        int[] intarr = StringUtil.stringToIntArray(arr);
        if (Arrays.stream(intarr).distinct().count() != arr.length()) {
            throw new DepulicatedException();
        }
    }
    private void checkInputTypeException(String arr) {
        // 고민
    }
    private static void checkInputZeroException(String arr) {
        if (arr.contains("0")) throw new NumberOfInputException();
    }
    private static void checkNumberOfInputException(String arr) {
        if (arr.length() != 3) throw new ReplayInputException();
    }

}