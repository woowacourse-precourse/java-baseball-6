package baseball;

import java.util.Arrays;

public class NumberException {
    private boolean isException;
    public NumberException(){
        isException = false;
    }

    public void checkPlayerInputException(String inputString){
        isException =  isLengthThree(inputString) || isDuplicateValue(inputString) || isOutOfRange(inputString);
        if(isException){
            throwIllegalArgumentException();
        }
    }
    
    public void checkPlayerQuitException(String playerInputQuit){
        isException= !playerInputQuit.equals("1") && !playerInputQuit.equals("2");
        if(isException){
            throwIllegalArgumentException();
        }
    }

    public static void throwIllegalArgumentException(){
        throw new IllegalArgumentException("IllegalArgumentException");
    }
    

    private boolean isDuplicateValue(String inputString) {
        char[] arr = inputString.toCharArray();
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return true;
            }
        }

        return false;
    }

    private boolean isOutOfRange(String inputString) {
        char[] chars = inputString.toCharArray();
        for (char ch : chars) {
            if (ch <'1' && ch>'9') {
                return true;
            }
        }

        return false;
    }

    private boolean isLengthThree(String inputString) {
        return inputString.length() != 3;
    }

}
