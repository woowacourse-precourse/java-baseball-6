package baseball.controller;

public class RestartServiceImpl implements RestartService {
    private static final String DO_RESTART_OPTION = "1";
    private static final String DONT_RESTART_OPTION = "2";

    public boolean chooseRestartOption(String restartOption) {
        checkValidRestartOption(restartOption);
        return restartOption.equals(DO_RESTART_OPTION);
    }

    private void checkValidRestartOption(String restartOption) {
        if(!isValidRestartOption(restartOption)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidRestartOption(String restartOption) {
        return restartOption.equals(DO_RESTART_OPTION) || restartOption.equals(DONT_RESTART_OPTION);
    }
}
