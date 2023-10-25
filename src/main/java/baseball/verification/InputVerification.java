package baseball.verification;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputVerification {
    public static void checkDuplication(int[] check){
        int size = Arrays.stream(check).distinct().toArray().length;

        if(size != 3){
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해주세요");
        }
    }
    public static void checkNumber(String str){
        String pattern = "^[1-9]{3}$";

        if(!Pattern.matches(pattern, str)){
            throw new IllegalArgumentException("3자리의 1~9까지의 수를 입력해주세요");
        }
    }
    public static void checkMenu(String str){
        if(str.equals("1") == str.equals("2")){
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
