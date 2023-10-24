package baseball.model.domain;

import baseball.model.service.RestartOptionValidator;

public class Restart {
    private final Integer restartOption;

    private Restart(String inputOption, RestartOptionValidator restartOptionValidator) {
        restartOptionValidator.validateRestartOption(inputOption);
        this.restartOption = parse(inputOption);
    }

    public static Restart of(String inputOption, RestartOptionValidator restartOptionValidator) {
        return new Restart(inputOption, restartOptionValidator);
    }

    public Integer getRestartOption() {
        return restartOption;
    }

    private Integer parse(String inputOption) {
        return Integer.parseInt(inputOption);
    }
}
