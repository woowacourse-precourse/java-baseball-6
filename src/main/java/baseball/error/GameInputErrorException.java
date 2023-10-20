package baseball.error;

public class GameInputErrorException implements ErrorException{
    @Override
    public void throwIlleegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }

    private boolean isNumeric(String checkNumber) {
        return checkNumber.matches("-?\\d+(\\.\\d+)?");
    }
}
