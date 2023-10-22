package baseball;

public class GameRestart {
    private static final String DO_RESTART_OPTION = "1";
    private static final String DONT_RESTART_OPTION = "2";

    public boolean wantRestartGame() {
        return chooseRestartGameOption().equals(DO_RESTART_OPTION);
    }

    private String chooseRestartGameOption() {
        Output.printRestartMessage(DO_RESTART_OPTION, DONT_RESTART_OPTION);
        String restartOption = Input.inputRestartOption();
        checkValidRestartOption(restartOption);
        return restartOption;
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
