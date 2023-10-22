package baseball.model.domain;

import baseball.model.service.RestartNumber;
import baseball.model.service.RestartNumberImpl;

public class Restart {
    private Integer restartNumber;

    public Restart(String inputNumber) {
        RestartNumber restartNumber = new RestartNumberImpl();
        restartNumber.isNonNumber(inputNumber);

        Integer convertNumber = convertNumber(inputNumber);
        restartNumber.isLengthCorrect(convertNumber);
        restartNumber.isRange(convertNumber);
        this.restartNumber = convertNumber(inputNumber);
    }

    public Integer getRestartNumber() {
        return restartNumber;
    }

    public Integer convertNumber(String inputNumber) {
        int num = Integer.parseInt(inputNumber);
        return num;
    }
}
