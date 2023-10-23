package baseball;

public class Validate {

    public static void isNumberValidate(int number){
        if ( number > 9 || number < 1) {
            throw new IllegalArgumentException("입력 값은 1~9의 정수입니다.");
        }
    }
}
