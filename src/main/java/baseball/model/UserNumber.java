package baseball.model;

import java.util.ArrayList;
import java.util.List;

// 일급 컬렉션
public class UserNumber {
    private final List<Integer> userNumber = new ArrayList<>();

    public UserNumber(String userNumber) {
        validateUserNumber(userNumber);
    }

    // 유저 번호를 반환해주는 함수
    public List<Integer> getUserNumber() {
        return this.userNumber;
    }

    private void validateUserNumber(String userInput) {
        // 입력이 숫자인지 검증
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자가 아닙니다.");
        }

        // 숫자인 경우, 3자리 수 검증 확인
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3자리 숫자가 아닙니다.");
        }

        // 숫자이고, 3자리 수인 경우, 중복 자리 수 검증
        for (int i = 0; i < userInput.length(); i++) {
            Integer num = Character.getNumericValue(userInput.charAt(i));
            checkDuplicateNum(num);
        }
    }

    // 중복 수 검증 함수
    private void checkDuplicateNum(Integer num) {
        if (!this.userNumber.contains(num)) {
            this.userNumber.add(num);
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다. 중복된 자리 수가 있습니다.");
        }
    }
}
