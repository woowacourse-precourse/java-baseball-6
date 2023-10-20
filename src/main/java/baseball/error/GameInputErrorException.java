package baseball.error;

public class GameInputErrorException implements ErrorException{
    @Override
    public void throwIlleegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }

    private
}
