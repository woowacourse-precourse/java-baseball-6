package baseball.model.domain;

import baseball.model.service.RestartOptionValidator;

public class Restart {
    private Integer restartOption;
    private RestartOptionValidator restartOptionValidator;

    public Restart(String inputOption, RestartOptionValidator restartOptionValidator) {
        this.restartOptionValidator = restartOptionValidator;
        restartOptionValidator.validateRestartOption(inputOption);
        this.restartOption = parseRestartOption(inputOption);
    }

    public Integer getRestartOption() {
        return restartOption;
    }

    private Integer parseRestartOption(String inputOption) {
        return Integer.parseInt(inputOption);
    }
}
