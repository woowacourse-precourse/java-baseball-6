package baseball;

import static baseball.Constants.validLength;

import java.util.HashSet;
import java.util.Set;

public class ExceptionHandler {
    public static boolean isAllDigit(String str){
        // 모두 숫자인지 확인
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isValidLength(String str){
        return str.length() == validLength;
    }
    public static boolean isValidNumber(String str) {
        // validLength 자리가 1~9로 이루어졌는지 확인
        String pattern = "^[1-9]{%d}$";
        String regex = String.format(pattern, validLength);
        if (!str.matches(regex)) {
            return false;
        }
        // 중복된 숫자 있는지 확인
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
}
