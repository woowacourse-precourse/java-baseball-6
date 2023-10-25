package baseball.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class CheckNumbers {
    public static boolean checkNormalNumbers(String str) {
        String pattern = "^[1-9]*$";

        // 숫자 형태로 되어 있지 않으며, 0이 들어가 있으면 false 반환
        if (!Pattern.matches(pattern, str)) {
            return false;
        }

        // 자릿수가 3자리가 아니라면, false 반환
        if (str.length() != 3) {
            return false;
        }

        // 문자열 내 중복 숫자를 확인하기 위해 Set을 사용함
        Set<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (charSet.contains(c)) {
                return false;
            }
            charSet.add(c);
        }

        return true;
    }

    public static boolean checkQuitNumbers(String str) {

        // 1: 재시작, 2: 종료
        if (str.equals("1") || str.equals("2")) {
            return true;
        }
        return false;
    }

}
