package baseball.error;

public class RetryInpurErrorException implements ErrorException{
    @Override
    public void checkUserInputValidate(String message) {
        throw new IllegalArgumentException(message);
    }
}
