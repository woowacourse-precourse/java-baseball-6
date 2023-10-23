package baseball;

import java.util.HashSet;
import java.util.Set;

public class Inspection {

    //길이 확인
    private void lengthCheck(String userInput){
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
        }
    }
    //범위 확인 (1~9)
    private void rangeCheck(String userInput){
        for (int i = 0; i < 3; i++) {
            char digit = userInput.charAt(i);
            int num = Character.getNumericValue(digit);

            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("입력값은 1부터 9 사이의 정수여야 합니다.");
            }
        }
    }
    //중복 확인
    private void duplicateCheck(String userInput){
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            char digit = userInput.charAt(i);
            int num = Character.getNumericValue(digit);

            if (!uniqueNumbers.add(num)) {
                throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
            }
        }
    }

    //입력예외테스트
    public void inputExceptionTest(String input){
        lengthCheck(input);
        duplicateCheck (input);
        rangeCheck(input);
    }

}
