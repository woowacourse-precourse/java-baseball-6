package baseball.error;

public class InputErrorException implements ErrorException{
    @Override
    public void throwIlleegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }
    
}
