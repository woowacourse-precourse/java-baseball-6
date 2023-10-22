package baseball;

public class PlayerNumber {
    private final String number;

    public PlayerNumber(String number, int length) {
        PlayerNumberValidator playerNumberValidator = new PlayerNumberValidator();
        if (playerNumberValidator.isValidNumber(number, length)) {
            this.number = number;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public char get(int index) {
        return number.charAt(index);
    }
}
