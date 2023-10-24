package baseball;

public class UserNumber {
    private String userNumber;

    public UserNumber(String input) {
        String userNumber = input;
        validateSpaceBar(userNumber);
        validateLength(userNumber);
        validateString(userNumber);
        this.userNumber = userNumber;
    }

    public void validateSpaceBar(String userNumber) {
        if (userNumber.contains(" ")) {
            userNumber.replace(" ", "");
        }
    }

    public void validateLength(String userNumber) {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("세개의 숫자를 입력해주세요.");
        }
    }

    public void validateString(String userNumber) {
        if (!Character.isDigit(userNumber.charAt(0)) ||
                !Character.isDigit(userNumber.charAt(1)) ||
                !Character.isDigit(userNumber.charAt(2))) {
            throw new IllegalArgumentException("숫자만 입력해주세요. 프로그램을 종료합니다.");
        }
    }

    public String getUserNumber() {
        return userNumber;
    }


}
