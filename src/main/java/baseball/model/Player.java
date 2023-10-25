package baseball.model;

public class Player {

    private final String number;

    public Player(final String number) {
        Validation.validateInputThreeNumber(number);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
