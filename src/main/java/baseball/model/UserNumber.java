package baseball.model;

public class UserNumber {
    private final String userNumber;

    public UserNumber(String userNumber) {
        UserNumberValidator.validateUserNumber(userNumber, NumberStatus.NUMBER_SIZE);
        this.userNumber = userNumber;
    }

    public String getUserNumber() {
        return userNumber;
    }
}
