package baseball;

public class PlayerNumber {
    private final String number;

    public PlayerNumber(String number) {
        PlayerNumberValidator playerNumberValidator = new PlayerNumberValidator();
        if (playerNumberValidator.isValidNumber(number)) {
            this.number = number;
        } else {
            throw new IllegalArgumentException(ErrorCode.INVALID_PLAY_NUMBER.getErrorMessage());
        }
    }

    public char get(int index) {
        return number.charAt(index);
    }
}
