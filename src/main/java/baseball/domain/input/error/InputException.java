package baseball.domain.input.error;


public final class InputException extends IllegalArgumentException {

    public InputException(String inputValue, InputError inputError) {
        super(inputValue + inputError.message);
    }

}
