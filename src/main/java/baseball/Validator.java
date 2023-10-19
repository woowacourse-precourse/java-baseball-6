package baseball;

public class Validator {

    public static void checkNumberLength(String number){
        // 입력받은 값의 길이가 3이 아닐 경우
        if(number.length() != Constant.BALL_SIZE){
            throw new IllegalArgumentException();
        }
    }
}