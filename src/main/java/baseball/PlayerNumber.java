package baseball;

public class PlayerNumber {
    private final String number;

    public PlayerNumber(String number) {
        PlayerNumberValidator playerNumberValidator = new PlayerNumberValidator();
        if (playerNumberValidator.isValidNumber(number)) {
            this.number = number;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public char get(int index) {
        return number.charAt(index);
    }
}
