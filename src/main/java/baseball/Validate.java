package baseball;

import java.util.List;
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

    public static void isLessThenFourLetter(String[] input){
        if(input.length >= 4){
            throw new IllegalArgumentException("입력 값은 3개 이하여야 합니다.");
        }
    }

    public static void isNumberDuplicate(List<Integer> user, int num) {
        if (user.contains(num)) {
            throw new IllegalArgumentException("입력 값은 서로 다른 값이여야 합니다.");
        }
    }
}
