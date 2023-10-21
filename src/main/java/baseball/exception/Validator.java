package baseball.exception;

public class Validator {

    public Validator() {

    }

    public boolean isNumeric(String input) {
        for(char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
