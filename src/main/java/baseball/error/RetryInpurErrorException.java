package baseball.error;

public class RetryInpurErrorException implements ErrorException{
    @Override
    public void throwIlleegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }
}
