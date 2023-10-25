package exception;

public class DuplicateBaseBallNumber extends IllegalArgumentException{
    public DuplicateBaseBallNumber(String message) {
        super(message);
    }
}
