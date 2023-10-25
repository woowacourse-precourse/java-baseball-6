package baseball.model.domain;

import baseball.model.service.Validator;

public class Restart {
    private final Integer restartOption;

    private Restart(String inputOption, Validator validator) {
        validator.validateRestartOption(inputOption);
        this.restartOption = parse(inputOption);
    }

    public static Restart of(String inputOption, Validator validator) {
        return new Restart(inputOption, validator);
    }

    public Integer getRestartOption() {
        return restartOption;
    }

    private Integer parse(String inputOption) {
        return Integer.parseInt(inputOption);
    }
}
