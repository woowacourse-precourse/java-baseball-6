package baseball.baseballGame;

public class CheckValidNum {
    // 사용자가 입력한 숫자 유효성 체크
    public void check(int num) {
        // 세 자리 수 확인
        if (String.valueOf(num).length() != 3) {
            throw new IllegalArgumentException();
        }

        // 음수 확인
        if (num < 0) {
            throw new IllegalArgumentException();
        }

        // 0 존재 여부 확인
        if (String.valueOf(num).contains("0")) {
            throw new IllegalArgumentException();
        }

        // 중복 숫자 확인
        boolean[] ch = new boolean[10];
        while (num > 0) {
            int digit = num % 10;
            if (ch[digit]) {
                throw new IllegalArgumentException();
            } else {
                ch[digit] = true;
            }
            num /= 10;
        }
    }
}
