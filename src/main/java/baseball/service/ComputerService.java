package baseball.service;

import static baseball.game.BaseballConstant.BASEBALL_MAX_NUMBER;
import static baseball.game.BaseballConstant.BASEBALL_MIN_NUMBER;
import static baseball.game.BaseballConstant.BASEBALL_NUMBERS_SIZE;

import baseball.domain.Computer;
import baseball.validator.BaseballValidator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class ComputerService {

    private final BaseballValidator baseballValidator;

    public ComputerService(BaseballValidator baseballValidator) {
        this.baseballValidator = baseballValidator;
    }

    public Computer create() {
        String baseballNumber = createBaseballNumber();
        baseballValidator.validate(baseballNumber);
        return new Computer(baseballNumber);
    }

    private String createBaseballNumber() {
        LinkedHashSet<String> result = new LinkedHashSet<>();

        while (result.size() < BASEBALL_NUMBERS_SIZE) {
            result.add(selectRandomNumber());
        }

        return String.join("", result);
    }

    private String selectRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(BASEBALL_MIN_NUMBER, BASEBALL_MAX_NUMBER);
        return Integer.toString(randomNumber);
    }
}
