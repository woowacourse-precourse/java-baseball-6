package baseball.member;

import baseball.view.InputView;

public class RestartOption {
    private String restartOption;
    private static final String DO_RESTART_OPTION = "1";
    private static final String DONT_RESTART_OPTION = "2";

    public boolean wantRestartGame() {
        chooseRestartGameOption();
        return restartOption.equals(DO_RESTART_OPTION);
    }

    private void chooseRestartGameOption() {
        String restartOption = InputView.inputRestartOption(DO_RESTART_OPTION, DONT_RESTART_OPTION);
        checkValidRestartOption(restartOption);
        this.restartOption = restartOption;
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
