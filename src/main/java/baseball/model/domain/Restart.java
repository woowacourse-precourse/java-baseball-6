package baseball.model.domain;

import baseball.model.service.RestartOptionValidator;
import baseball.model.service.RestartOptionValidatorImp;

public class Restart {
    private Integer restartOption;

    public Restart(String inputOption) {
        RestartOptionValidator restartOptionValidator = new RestartOptionValidatorImp();
        restartOptionValidator.isNonNumber(inputOption);
        restartOptionValidator.isLengthCorrect(inputOption);

        Integer convertNumber = convertNumber(inputOption);
        restartOptionValidator.isRange(convertNumber);
        this.restartOption = convertNumber(inputOption);
    }

    public Integer getRestartOption() {
        return restartOption;
    }

    public Integer convertNumber(String inputNumber) {
        int num = Integer.parseInt(inputNumber);
        return num;
    }
}
