package baseball.utils;

import baseball.Exception.DepulicatedException;
import baseball.Exception.InputTypeException;
import baseball.Exception.NumberOfInputException;
import baseball.Exception.ReplayInputException;

import java.util.Arrays;


public class StringException {

    public static void checkUserInputTotal(String arr, int n){
        checkDuplicated(arr);
        checkInputZero(arr);
        checkNumberOfInput(arr, n);
        checkInputType(arr);
    }
    public static void checkReplayInput(int a) {
        if (a != 1 && a!= 2) throw new ReplayInputException();
    }
    private static void checkDuplicated(String arr) {
        int[] intarr = StringUtil.stringToIntArray(arr);
        if (Arrays.stream(intarr).distinct().count() != arr.length()) {
            throw new DepulicatedException();
        }
    }
    private static boolean isInteger(String arr) {
        // 고민
        try {
            Integer.parseInt(arr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static void checkInputType(String arr) {
        if (!isInteger(arr)) {
            throw new InputTypeException();
        }
    }
    private static void checkInputZero(String arr) {
        if (arr.contains("0")) throw new NumberOfInputException();
    }
    private static void checkNumberOfInput(String arr, int n) {
        if (arr.length() != n) throw new ReplayInputException();
    }

}