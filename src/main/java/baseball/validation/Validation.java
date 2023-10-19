package baseball.validation;

public interface Validation<Input> {

    boolean validation(Input inputValue);
}
