package baseball.io.input.validation;

public interface Validation<Input> {

    boolean validation(Input inputValue);
}
