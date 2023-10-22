package baseball.domain.input.error;


public final class InputException extends IllegalArgumentException{

    public InputException(InputError inputError){
        super(inputError.message);
    }

}
