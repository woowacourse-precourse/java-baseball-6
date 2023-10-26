package baseball;

import java.util.HashSet;
import java.util.Set;

import static baseball.Constants.*;

public class ExceptionHandler {
    public static boolean isAllDigit(String str) {
        // 모두 숫자인지 확인
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidLength(String str) {
        return str.length() == validLength;
    }

    public static boolean isValidNumber(String str) {
        // validLength 자리가 1~9로 이루어졌는지 확인
        String pattern = "^[1-9]{%d}$";
        String regex = pattern.formatted(validLength);
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

    public static void raiseException(String userNumber) {
        if(!ExceptionHandler.isAllDigit(userNumber)){
            throw new IllegalArgumentException("숫자가 아닌 입력이 들어왔습니다.");
        }
        if(!ExceptionHandler.isValidLength(userNumber)){
            throw new IllegalArgumentException("3자리가 아닌 숫자가 입력으로 들어왔습니다.");
        }
        if(!ExceptionHandler.isValidNumber(userNumber)){
            throw new IllegalArgumentException("0이 포함되거나 중복된 숫자가 입력으로 들어왔습니다.");
        }
    }

    public static boolean isValidContinueCommand(String str) {
        return str.equals(SystemMessage.GAMECONTINUE.get()) || str.equals(SystemMessage.GAMESTOP.get());
    }

    public static void raiseContinueCommandException(String continueCommand){
        if(!isValidContinueCommand(continueCommand)){
            throw new IllegalArgumentException("1 또는 2가 아닌 잘못된 입력이 들어왔습니다.");
        }
    }
}
