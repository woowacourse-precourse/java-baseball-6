package baseball.validation;

public class PlayOrStopInputValidator implements InputValidator {

    @Override
    public void validateInput(String input) {
        checkInputLengthValidity(input);
        checkInputOneOrTwo(input);
        checkInputIsNumeric(input);
    }

    private void checkInputLengthValidity(String input) throws IllegalArgumentException {
        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInputOneOrTwo(String input) throws IllegalArgumentException {
        int number = Integer.parseInt(input);
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInputIsNumeric(String input) throws IllegalArgumentException {
        if(!Character.isDigit(input.charAt(0))){
            throw new IllegalArgumentException();
        }
    }




}
