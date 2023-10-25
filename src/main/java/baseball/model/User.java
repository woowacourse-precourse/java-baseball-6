package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private List<Integer> userNumber;

    private final int VALIDATE_SIZE = 3;

    public User() {
        this.userNumber = new ArrayList<>();
    }

    // controller에서 userNumber를 로직 처리를 하기 위해
    public List<Integer> getUserNumber() {
        return userNumber;
    }

    // view에서 받은 input을 user 모델에서 갖고 있기 위함
    public void setUserNumber(String input) {
        resetUserNumber();  // userNumber 초기화
        // input된 숫자 검증
        if(validateInputNumber(input)) {
            generateUserNumber(input);   // generate
        }
    }

    private void resetUserNumber() {
        if(userNumber != null) {
            userNumber.clear();
        }
    }

    // userNumber 생성
    private void generateUserNumber(String input) {
        userNumber.add(Integer.valueOf(input.substring(0, 1)));
        userNumber.add(Integer.valueOf(input.substring(1, 2)));
        userNumber.add(Integer.valueOf(input.substring(2, 3)));
    }

    // inputNumber 검증
    private boolean validateInputNumber(String input) {
        return validateNumberSize(input) && validateNumberRange(input) && validateNumberDuplicate(input);
    }

    // input size 검증
    private boolean validateNumberSize(String input) {
        if (input.length() != VALIDATE_SIZE) {
            throw new IllegalArgumentException("3자리 숫자를 입력하지 않았습니다.");
        }
        return true;
    }

    // 0 - 9 사이의 숫자인지
    private boolean validateNumberRange(String input) {
        if(!input.matches("[1-9]+")) {
            throw new IllegalArgumentException("1-9 사이의 숫자로 구성되지 않았습니다.");
        }
        return true;
    }

    // HashSet을 이용한 List 중복제거
    private boolean validateNumberDuplicate(String input) {
        List<Integer> inputList = input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();

        Set<Integer> uniqueNumbers = new HashSet<>(inputList);

        if (uniqueNumbers.size() != inputList.size()) {
            throw new IllegalArgumentException("입력 값은 서로 다른 세 자리 숫자여야 합니다.");
        }

        return true;
    }
}