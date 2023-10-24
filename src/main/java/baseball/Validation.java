package baseball;

import static baseball.GameComponent.*;
public class Validation {

    public void isValidInput() {
        // 3자리 숫자 입력 안했을 시 에러 처리
        if(userNum.length() != DIGIT) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < DIGIT; i++){
            inRange(i);
            noOverlap(i);
        }
    }

    private void inRange(int i) {
        // 1 ~ 9 아닌 수가 있을 시 에러 처리
        if(userNum.charAt(i) < '1' || userNum.charAt(i) > '9') {
            throw new IllegalArgumentException();
        }
    }

    private void noOverlap(int i){
        // 중복값 있을 시 에러 처리
        for(int j = i + 1; j < DIGIT; j++) {
            if(userNum.charAt(i) == userNum.charAt(j)){
                throw new IllegalArgumentException();
            }
        }
    }
}
