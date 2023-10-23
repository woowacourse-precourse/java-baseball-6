package baseball.model;

import static baseball.util.InputValidator.isRestartOrExitValid;

import camp.nextstep.edu.missionutils.Console;

public enum RestartOrExit {

    DEFAULT(0), RESTART(1), EXIT(2);

    private Integer restartOrExit;

    RestartOrExit(Integer restartOrExit) {
        this.restartOrExit = restartOrExit;
    }

    public void input() {
        String input = Console.readLine();
        validateInputRestartOrExit(input);
        this.restartOrExit = Integer.parseInt(input);
    }

    private void validateInputRestartOrExit(String input) {
        if (!isRestartOrExitValid(input)) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getRestartOrExit() {
        return restartOrExit;
    }
}
