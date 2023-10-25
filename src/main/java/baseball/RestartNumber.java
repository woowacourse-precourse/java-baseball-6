package baseball;

public class RestartNumber {
    private final String RESTART_STRING = "1";
    private String restartNumber;
    public RestartNumber(String restartNumber) {
        ExceptionCheck.checkRestartNumber(restartNumber);
        this.restartNumber = restartNumber;
    }
    public boolean isRestart() {
        return restartNumber.equals(RESTART_STRING);
    }
}
