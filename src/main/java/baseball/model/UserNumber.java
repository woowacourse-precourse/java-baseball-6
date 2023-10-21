package baseball.model;

public class UserNumber {
    private final String userNumber;

    public UserNumber(String userNumber, int numberSize) {
        UserNumberValidator.validateUserNumber(userNumber, numberSize);
        this.userNumber = userNumber;
    }

    public String getUserNumber() {
        return userNumber;
    }
}
