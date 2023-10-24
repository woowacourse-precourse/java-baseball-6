package baseball.model;

public class RestartOrExitNumber {

    private static final int GAME_RESTART_NUMBER = 1;
    private static final int GAME_EXIT_NUMBER = 2;

    private int restartOrExitNumber;

    public RestartOrExitNumber(int restartOrExitNumber) {
        validate(restartOrExitNumber);
        this.restartOrExitNumber = restartOrExitNumber;
    }

    public void validate(int restartOrExitNumber) {
        if (isCorrectNumber(restartOrExitNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isCorrectNumber(int restartOrExitNumber) {
        return (restartOrExitNumber != GAME_RESTART_NUMBER) && (restartOrExitNumber != GAME_EXIT_NUMBER);
    }
}