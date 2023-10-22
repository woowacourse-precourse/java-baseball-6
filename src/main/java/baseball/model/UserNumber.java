package baseball.model;

import java.util.List;

public class UserNumber {
    private final List<Integer> userNumber;

    public UserNumber(String userNumber) {
        this.userNumber = validateUserNumber(userNumber);
    }

    public List<Integer> getUserNumber() {
        return this.userNumber;
    }

    private List<Integer> validateUserNumber(String userInput) {
        // 숫자인지 검증
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        // 3자리 수 검증 확인
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        // 중복 자리수 검증
        for (int i = 0; i < userInput.length(); i++) {
            int num = Character.getNumericValue(userInput.charAt(i));
            if (!userNumber.contains(num)) {
                userNumber.add(num);
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }
}
