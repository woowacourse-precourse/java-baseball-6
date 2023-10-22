package baseball.model;

public class UserNumber {
    private final String userNumber;

    public UserNumber(String userNumber) {
        UserNumberValidator.validateUserNumber(NumberStatus.NUMBER_SIZE, userNumber);
        this.userNumber = userNumber;
    }

    public String getUserNumber() {
        return userNumber;
    }
}
