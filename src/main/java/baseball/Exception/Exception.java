package baseball.Exception;

import baseball.Game.Choice;

import java.util.List;

public class Exception {
    public static void validateInputLength(String s) {
        if (s.length() != 3) {
            throw new IllegalArgumentException("3자리의 수만 입력 가능 합니다.");
        }
    }
    public static void validateNonDigitCharacter(Character c){

        if(!Character.isDigit(c)){
            throw new IllegalArgumentException("숫자가 아닌 문자는 입력하실 수 없습니다.");
        }
    }

    public static void validateMinimumValue(Character c){

        if (Integer.parseInt(String.valueOf(c)) < 1) {
            throw new IllegalArgumentException("1보다 작은 수 는 입력 하실 수 없습니다.");
        }
    }

    public static void validateDuplicates(List<Integer> user,Character c){
        if(user.contains(c-48)){
            throw new IllegalArgumentException("숫자가 중복 되었습니다.");
        }
    }

    public static void validateChoice(Choice c){
        if(c == null){
            throw new IllegalArgumentException("1 또는 2만 입력 가능 합니다.");
        }
    }
}
