package baseball.error;

public class CheckRestartNumber {

    public static void checkLength(String input){
        if(input.length() != 1){
            throw new IllegalArgumentException("잘못된 길이의 값이 입력되었습니다.");
        }
    }

    public static void checkNumber(String input){
        char inputChar = input.charAt(0);
        if(!('1' <= inputChar && inputChar <= '2')){
            throw new IllegalArgumentException("숫자 외의 다른 값이 입력되었습니다.");
        }
    }
}

