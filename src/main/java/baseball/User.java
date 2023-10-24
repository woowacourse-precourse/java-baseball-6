package baseball;

public class User {

    private Number number;

    private User() {
    }

    public static User create() {
        return new User();
    }

    public void setInputNumber(String input) {
        number = Number.create(input);
    }

    public Number getNumber() {
        return number;
    }
}
