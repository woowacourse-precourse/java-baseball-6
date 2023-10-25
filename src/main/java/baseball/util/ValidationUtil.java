package baseball.util;
import static baseball.common.Constants.*;

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
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다.");
        }

        if(!isValidRange(str)){
            throw new IllegalArgumentException("입력값이 1~9 범위가 아닙니다.");
        }

        if(!isValidLength(str)){
            throw new IllegalArgumentException("입력값이 세자리가 아닙니다.");
        }

        if(isDuplicated(str)){
            throw new IllegalArgumentException("입력값이 중복되었습니다.");
        }
    }
}
