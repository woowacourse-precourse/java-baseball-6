package baseball.model;

import java.util.ArrayList;
import java.util.List;

// 일급 컬렉션
public class UserNumber {
    private final List<Integer> userNumber = new ArrayList<>();

    public UserNumber(String userNumber) {
        isNumeric(userNumber);
        isThreeDigitNumber(userNumber);
        for (int i = 0; i < userNumber.length(); i++) {
            Integer num = Character.getNumericValue(userNumber.charAt(i));
            isDuplicateDigit(num);
            // 중복까지 통과하면 하나씩 더하기
            this.userNumber.add(num);
        }
    }

    // 중복된 수가 있는지 검증
    private void isDuplicateDigit(Integer num) {
        if (this.userNumber.contains(num)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 중복된 자리 수가 있습니다.");
        }
    }

    // 3자리 수 인지 검증
    private void isThreeDigitNumber(String userNumber) {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3자리 숫자가 아닙니다.");
        }
    }

    // 숫자인지 확인
    private void isNumeric(String userNumber) {
        try {
            Integer.parseInt(userNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자가 아닙니다.");
        }
    }

    // 유저 번호를 반환해주는 함수
    public List<Integer> getUserNumber() {
        return this.userNumber;
    }
}
