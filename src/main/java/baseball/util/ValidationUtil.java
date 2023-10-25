package baseball.util;
import static baseball.common.Constants.*;
import static baseball.common.ErrorMessage.*;

public class ValidationUtil {

    public static boolean isValidRange(String str) {
        for(char digit : str.toCharArray()){
            int num = Character.getNumericValue(digit);
            if(num >= MIN_NUMBER && num <= MAX_NUMBER) return true;
        }
        return false;
    }

    public static boolean isValidLength(String str) {
        return str.length() == 3;
    }

    public static boolean isDuplicated(String str) {
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length(); j++){
                if(str.charAt(i) == str.charAt(j)) return true;
            }
        }
        return false;
    }

    private static boolean isDigits(String str) {
        for (char digit : str.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }

    public static void isValidInput(String str) {
        if (!isDigits(str)) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }

        if(!isValidRange(str)){
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }

        if(!isValidLength(str)){
            throw new IllegalArgumentException(NUMBER_LENGTH_ERROR_MESSAGE);
        }

        if(isDuplicated(str)){
            throw new IllegalArgumentException(NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }
}