package baseball.model;

public class RestartOrExitNumber {

    private int restartOrExitNumber;

    public RestartOrExitNumber(int restartOrExitNumber) {
        validate(restartOrExitNumber);
        this.restartOrExitNumber = restartOrExitNumber;
    }

    public void validate(int restartOrExitNumber) {
        if ((restartOrExitNumber != 1) || (restartOrExitNumber != 2)) {
            throw new IllegalArgumentException();
        }
    }
}