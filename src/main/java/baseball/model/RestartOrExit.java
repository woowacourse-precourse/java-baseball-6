package baseball.model;

public enum RestartOrExit {

    RESTART(1), EXIT(2);

    private Integer restartOrExit;

    RestartOrExit(Integer restartOrExit) {
        this.restartOrExit = restartOrExit;
    }

}
