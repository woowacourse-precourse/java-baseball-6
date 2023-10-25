package baseball;

import java.util.regex.Pattern;

public class Validate {

    public static void isNumberValidate(int number){
        if ( number > 9 || number < 1) {
            throw new IllegalArgumentException("입력 값은 1~9의 정수입니다.");
        }
    }

    public static void isOneOrTwo(String str) {
        if (!Pattern.matches("[1|2]", str)) {
            throw new IllegalArgumentException("게임을 시작하려면 1혹은 2를 입력해야 합니다.");
        }
    }
}
