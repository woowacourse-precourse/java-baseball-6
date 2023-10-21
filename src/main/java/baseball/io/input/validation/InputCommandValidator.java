package baseball.io.input.validation;

public class InputCommandValidator implements Validation<String> {

    private static InputCommandValidator instance;

    private InputCommandValidator() {}

    public static InputCommandValidator singleton() {
        if (instance == null) {
            instance = new InputCommandValidator();
        }
        return instance;
    }

    @Override
    public boolean validation(String inputValue) {
        return inputValue.equals("1") || inputValue.equals("2");
    }
}
