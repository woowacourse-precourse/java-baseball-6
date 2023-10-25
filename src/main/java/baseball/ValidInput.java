package baseball;

public class ValidInput {

    // 1~9 사이의 숫자이고, 겹치는 숫자가 없는지 유효성 체크 메소드
    public static boolean isValidInput(int number) {
        if ( number >= 123 && number <= 987 ) {
            int a = number / 100;
            int b = (number / 10) % 10;
            int c = number % 10;

            return a != b && b != c && a != c;
        }
        return false;
    }
}
