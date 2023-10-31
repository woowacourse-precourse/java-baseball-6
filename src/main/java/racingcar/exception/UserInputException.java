package racingcar.exception;

public class UserInputException extends IllegalArgumentException {

    private String msg;

    public UserInputException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
