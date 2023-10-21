package baseball.model;

public class user {
    private String userNumber;

    // controller에서 userNumber를 로직 처리를 하기 위해
    public String getUserNumber() {
        return userNumber;
    }

    // view에서 받은 input을 user 모델에서 갖고 있기 위함
    public void setUserNumber(String userNumber) {
        if(validateNumber(userNumber)) {
            this.userNumber = userNumber;
        }
    }

    // 3개를 입력했는지 / 0 - 9 사이 숫자인지 / 서로 다른 세 자리 숫자인지 검증
    public boolean validateNumber(String userNumber) {
        if(userNumber.length() != 3 ||
                !userNumber.matches("[0-9]+") ||
                hasDuplicateCharacters(userNumber)) {
            throw new IllegalArgumentException("입력 값은 서로 다른 세 자리 숫자여야 합니다.");
        } else
            return true;
    }

    // 서로 다른 숫자인지 검증
    private boolean hasDuplicateCharacters(String userNumber) {
        return userNumber.chars()
                .distinct()
                .count() != userNumber.length();
    }
}



