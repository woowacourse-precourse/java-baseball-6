package baseball;

public class Game {

    public String validateUserNumber(String userNumber) {
        if (isNumber(userNumber)) {
            throw new IllegalArgumentException("숫자가 아니다");
        }
        if (isDuplicateNumber(userNumber)) {
            throw new IllegalArgumentException("중복 숫자가 존재한다");
        }
        return userNumber;
    }

    private boolean isNumber(String userNumber) {
        return !userNumber.matches("[0-9]+");
    }

    private boolean isDuplicateNumber(String userNumber) {
        return userNumber.charAt(0) == userNumber.charAt(1) ||
                userNumber.charAt(0) == userNumber.charAt(2) ||
                userNumber.charAt(1) == userNumber.charAt(2);
    }
}
